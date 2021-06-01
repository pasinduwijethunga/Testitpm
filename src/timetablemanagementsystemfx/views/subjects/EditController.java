package timetablemanagementsystemfx.views.subjects;

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
import timetablemanagementsystemfx.models.SubjectModel;
import timetablemanagementsystemfx.utils.dbConnection;

public class EditController implements Initializable {

    @FXML
    private TextField txt_numberOfLabHours;
    @FXML
    private ComboBox<SubjectModel> cmb_subjectCode;
    @FXML
    private TextField txt_subjectName;
    @FXML
    private ComboBox<String> cmb_offeredYear;
    @FXML
    private ComboBox<String> cmb_offeredSemester;
    @FXML
    private TextField txt_numberOfLecturerHours;
    @FXML
    private TextField txt_numberOfTutorialHours;
    @FXML
    private TextField txt_numberOfEvaluationHours;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillOfferedYearCombo();
        fillOfferedSemesterCombo();
        fillSubjectCombo();
    }    
    
    private void fillOfferedYearCombo() {
        try {
            cmb_offeredYear.getItems().clear();
            ObservableList<String> offeredYear = FXCollections.observableArrayList();
            for(int i = 2000; i < 3000; i++) {

                offeredYear.add(String.valueOf(i));
                
            }
            cmb_offeredYear.setItems(offeredYear);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillOfferedSemesterCombo() {
        try {
            cmb_offeredSemester.getItems().clear();
            ObservableList<String> offeredSemester = FXCollections.observableArrayList();
            offeredSemester.add("1st Year 1st Semester");
            offeredSemester.add("1st Year 2st Semester");
            offeredSemester.add("2st Year 1st Semester");
            offeredSemester.add("2st Year 2st Semester");
            offeredSemester.add("3st Year 1st Semester");
            offeredSemester.add("3st Year 2st Semester");
            offeredSemester.add("4st Year 1st Semester");
            offeredSemester.add("4st Year 2st Semester");
            
            cmb_offeredSemester.setItems(offeredSemester);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    

    private void fillSubjectCombo() {
        String sql = "SELECT * FROM subject";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_subjectCode.getItems().clear();
            ObservableList<SubjectModel> subjects = FXCollections.observableArrayList();
            while (rs.next()) {
                subjects.add(new SubjectModel(rs.getString("subjectCode"), rs.getString("subjectName"), rs.getString("offeredYear"), rs.getString("offeredSemester"), Integer.parseInt(rs.getString("noOfLecHours")), Integer.parseInt(rs.getString("noOfTutHours")), Integer.parseInt(rs.getString("noOfLabHours")), Integer.parseInt(rs.getString("noOfEvaHours"))));
            }
            cmb_subjectCode.setItems(subjects);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void loadSubject(ActionEvent event) {
        if (cmb_subjectCode.getSelectionModel().getSelectedItem() != null) {
            SubjectModel sub = cmb_subjectCode.getSelectionModel().getSelectedItem();
            txt_subjectName.setText(sub.getSubjectName());
            txt_numberOfLecturerHours.setText(String.valueOf(sub.getNoOfLecHours()));
            txt_numberOfTutorialHours.setText(String.valueOf(sub.getNoOfTutHours()));
            txt_numberOfLabHours.setText(String.valueOf(sub.getNoOfLabHours()));
            txt_numberOfEvaluationHours.setText(String.valueOf(sub.getNoOfEveHours()));
            cmb_offeredYear.getSelectionModel().select(sub.getOfferedYear());
            cmb_offeredSemester.getSelectionModel().select(sub.getOfferedSemester());
        }
    }

    @FXML
    private void reset(MouseEvent event) {
        resetForm();
    }

    @FXML
    private void save(MouseEvent event) {
        if (!"".equals(txt_subjectName.getText().trim())
                && !"".equals(txt_numberOfEvaluationHours.getText().trim())
                && !"".equals(txt_numberOfLabHours.getText().trim())
                && !"".equals(txt_numberOfTutorialHours.getText().trim())
                && !"".equals(txt_numberOfLecturerHours.getText().trim())
                && cmb_offeredYear.getSelectionModel().getSelectedItem() != null
                && cmb_offeredSemester.getSelectionModel().getSelectedItem() != null) {

            try {

                Connection con = dbConnection.getConnection();
                String sql = "UPDATE subject SET `subjectName` = ?, `offeredYear` = ?, `offeredSemester` = ?, `noOfLecHours` = ?, `noOfTutHours` = ?, `noOfLabHours` = ?, `noOfEvaHours` = ? WHERE `subjectCode` = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, txt_subjectName.getText().trim());
                pstmt.setString(2, cmb_offeredYear.getSelectionModel().getSelectedItem());
                pstmt.setString(3, cmb_offeredSemester.getSelectionModel().getSelectedItem());
                pstmt.setInt(4, Integer.parseInt(txt_numberOfLecturerHours.getText().trim()));
                pstmt.setInt(5, Integer.parseInt(txt_numberOfTutorialHours.getText().trim()));
                pstmt.setInt(6, Integer.parseInt(txt_numberOfLabHours.getText().trim()));
                pstmt.setInt(7, Integer.parseInt(txt_numberOfEvaluationHours.getText().trim()));
                pstmt.setString(8, cmb_subjectCode.getSelectionModel().getSelectedItem().getSubjectCode());
                
                if (pstmt.executeUpdate() == 1) {
                    resetForm();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject updated");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject not updated!");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Subject not updated!");
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
    
    private void resetForm() {
        cmb_subjectCode.getSelectionModel().clearSelection();
        txt_subjectName.setText("");
        txt_numberOfLabHours.setText("");
        txt_numberOfEvaluationHours.setText("");
        txt_numberOfLecturerHours.setText("");
        txt_numberOfTutorialHours.setText("");
        cmb_offeredYear.getSelectionModel().clearSelection();
        cmb_offeredSemester.getSelectionModel().clearSelection();
    }  
}
