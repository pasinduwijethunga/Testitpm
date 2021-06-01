package timetablemanagementsystemfx.views.sessions;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import timetablemanagementsystemfx.models.Lecturer;
import timetablemanagementsystemfx.models.LecturerModel;
import timetablemanagementsystemfx.models.SessionModel;
import timetablemanagementsystemfx.models.Subject;
import timetablemanagementsystemfx.models.Tag;
import timetablemanagementsystemfx.utils.dbConnection;

public class EditController implements Initializable {

    @FXML
    private TextField txt_studentCount;
    @FXML
    private ComboBox<SessionModel> cmb_session;
    @FXML
    private ComboBox<Lecturer> cmb_lecturer;
    @FXML
    private ComboBox<Subject> cmb_subject;
    @FXML
    private ComboBox<String> cmb_subjectCode;
    @FXML
    private ComboBox<Tag> cmb_tag;
    @FXML
    private ComboBox<String> cmb_groupId;
    @FXML
    private TextField txt_duration;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillSessionCombo();
        fillLecturerCmb();
        fillSubjectcmbs();
        fillGroupCmb();
        fillTagCmb();
    }

    private void fillSessionCombo() {
        String sql = "SELECT * FROM session";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_session.getItems().clear();
            ObservableList<SessionModel> sessions = FXCollections.observableArrayList();
            while (rs.next()) {
                sessions.add(new SessionModel(Integer.parseInt(rs.getString("id")), rs.getString("lecturer"), rs.getString("subjectname"), rs.getString("subjectcode"), rs.getString("sgroupid"), rs.getString("tag"), rs.getString("duration"), rs.getString("studentcount")));
            }
            cmb_session.setItems(sessions);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillLecturerCmb() {
        try {
            String query = "SELECT * FROM lecturer";
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.prepareStatement(query).executeQuery();
            cmb_lecturer.getItems().clear();
            ObservableList<Lecturer> lecs = FXCollections.observableArrayList();
            while (rs.next()) {
                lecs.add(new Lecturer(rs.getString("lecturerId"), rs.getString("name")));
            }
            cmb_lecturer.setItems(lecs);
            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillSubjectcmbs() {
        try {
            String query = "SELECT * FROM subject";
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.prepareStatement(query).executeQuery();
            cmb_subject.getItems().clear();
            cmb_subjectCode.getItems().clear();
            ObservableList<Subject> sub = FXCollections.observableArrayList();
            ObservableList<String> subc = FXCollections.observableArrayList();
            while (rs.next()) {
                sub.add(new Subject(rs.getString("subjectCode"), rs.getString("subjectName")));
                subc.add(rs.getString("subjectCode"));

            }
            cmb_subject.setItems(sub);
            cmb_subjectCode.setItems(subc);
            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillTagCmb() {
        try {
            String query = "SELECT * FROM managetags";
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.prepareStatement(query).executeQuery();
            cmb_tag.getItems().clear();
            ObservableList<Tag> tags = FXCollections.observableArrayList();
            while (rs.next()) {
                tags.add(new Tag(rs.getInt("id"), rs.getString("tname")));
            }
            cmb_tag.setItems(tags);
            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillGroupCmb() {
        try {
            String query = "SELECT * FROM generateid";
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.prepareStatement(query).executeQuery();
            cmb_groupId.getItems().clear();
            ObservableList<String> grps = FXCollections.observableArrayList();
            while (rs.next()) {
                grps.add(rs.getString("subgid"));
            }
            cmb_groupId.setItems(grps);
            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void resetForm() {
        txt_duration.setText("");
        txt_studentCount.setText("");
        cmb_groupId.getSelectionModel().clearSelection();
        cmb_lecturer.getSelectionModel().clearSelection();
        cmb_subject.getSelectionModel().clearSelection();
        cmb_subjectCode.getSelectionModel().clearSelection();
        cmb_tag.getSelectionModel().clearSelection();
        cmb_session.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void loadSession(ActionEvent event) {
        if (cmb_session.getSelectionModel().getSelectedItem() != null) {
            SessionModel ses = cmb_session.getSelectionModel().getSelectedItem();
            txt_studentCount.setText(ses.getStudentcount());
            txt_duration.setText(ses.getDuration());
            cmb_groupId.getSelectionModel().select(ses.getSgroupid());

            cmb_lecturer.getItems().stream().filter((next) -> (next.getId() == null ? ses.getLecturer() == null : next.getId().equals(ses.getLecturer()))).forEachOrdered((next) -> {
                cmb_lecturer.getSelectionModel().select(next);
            });

            cmb_subject.getItems().stream().filter((next) -> (next.getName() == null ? ses.getSubjectname() == null : next.getName().equals(ses.getSubjectname()))).forEachOrdered((next) -> {
                cmb_subject.getSelectionModel().select(next);
            });

            cmb_tag.getItems().stream().filter((next) -> (next.getId() == Integer.parseInt(ses.getTag()))).forEachOrdered((next) -> {
                cmb_tag.getSelectionModel().select(next);
            });
        }
    }
    
    @FXML
    private void onChangeSubject(ActionEvent event) {
        if (cmb_subject.getSelectionModel().getSelectedItem() != null) {
            cmb_subjectCode.getItems().stream().filter((subCode) -> (subCode == null ? cmb_subject.getSelectionModel().getSelectedItem().getCode() == null : subCode.equals(cmb_subject.getSelectionModel().getSelectedItem().getCode()))).forEachOrdered((subCode) -> {
                cmb_subjectCode.getSelectionModel().select(subCode);
            });
        }
    }

    @FXML
    private void onChangeSubjectCode(ActionEvent event) {
        if (cmb_subjectCode.getSelectionModel().getSelectedItem() != null) {
            cmb_subject.getItems().stream().filter((sub) -> (sub.getCode() == null ? cmb_subjectCode.getSelectionModel().getSelectedItem() == null : sub.getCode().equals(cmb_subjectCode.getSelectionModel().getSelectedItem()))).forEachOrdered((sub) -> {
                cmb_subject.getSelectionModel().select(sub);
            });
        }
    }

    @FXML
    private void reset(MouseEvent event) {
        resetForm();
    }

    @FXML
    private void save(MouseEvent event) {
        if (!"".equals(txt_duration.getText().trim())
                && !"".equals(txt_studentCount.getText().trim())
                && cmb_groupId.getSelectionModel().getSelectedItem() != null
                && cmb_lecturer.getSelectionModel().getSelectedItem() != null
                && cmb_subject.getSelectionModel().getSelectedItem() != null
                && cmb_subjectCode.getSelectionModel().getSelectedItem() != null
                && cmb_tag.getSelectionModel().getSelectedItem() != null) {
            try {
                Connection con = dbConnection.getConnection();
                String sql = "UPDATE session SET `lecturer` = ?, `subjectname` = ?, `subjectcode` = ?, `sgroupid` = ?, `tag` = ?, `duration` = ?, `studentcount` = ? WHERE `id` = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, cmb_lecturer.getSelectionModel().getSelectedItem().getId());
                pstmt.setString(2, cmb_subject.getSelectionModel().getSelectedItem().getName());
                pstmt.setString(3, cmb_subject.getSelectionModel().getSelectedItem().getCode());
                pstmt.setString(4, cmb_groupId.getSelectionModel().getSelectedItem());
                pstmt.setInt(5, cmb_tag.getSelectionModel().getSelectedItem().getId());
                pstmt.setString(6, txt_duration.getText().trim());
                pstmt.setString(7, txt_studentCount.getText().trim());
                pstmt.setInt(8, cmb_session.getSelectionModel().getSelectedItem().getId());

                if (pstmt.executeUpdate() == 1) {
                    resetForm();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Session updated");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Session not updated!");
                    alert.showAndWait();
                }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Session not updated!");
                alert.showAndWait();
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please fill all required fields.");
            alert.showAndWait();
        }
    }
}
