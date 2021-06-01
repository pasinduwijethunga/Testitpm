package timetablemanagementsystemfx.views.sessions;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import timetablemanagementsystemfx.utils.dbConnection;

public class ViewController implements Initializable {
    private Session session = null;

    @FXML
    private TableView<Session> tbl_data;
    @FXML
    private ComboBox<Lecturer> cmb_lecturer;
    @FXML
    private ComboBox<Subject> cmb_subject;
    @FXML
    private ComboBox<String> cmb_subjectCode;
    @FXML
    private ComboBox<String> cmb_groupId;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillLecturerCmb();
        fillSubjectcmbs();
        fillGroupCmb();
        String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                + "FROM session S, managetags T, lecturer L "
                + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId";
        buildTable(query);
    }

    @FXML
    private void filterByLecturer(ActionEvent event) {
        if (cmb_lecturer.getSelectionModel().getSelectedItem() != null) {
            String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                    + "FROM session S, managetags T, lecturer L "
                    + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId AND S.lecturer = '" + cmb_lecturer.getSelectionModel().getSelectedItem().getId() + "'";
            buildTable(query);
            cmb_groupId.getSelectionModel().clearSelection();
            cmb_subject.getSelectionModel().clearSelection();
            cmb_subjectCode.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void filterBySubject(ActionEvent event) {
        if (cmb_subject.getSelectionModel().getSelectedItem() != null) {
            String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                    + "FROM session S, managetags T, lecturer L "
                    + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId AND S.subjectcode = '" + cmb_subject.getSelectionModel().getSelectedItem().getCode() + "'";
            buildTable(query);
            cmb_lecturer.getSelectionModel().clearSelection();
            cmb_groupId.getSelectionModel().clearSelection();
            cmb_subjectCode.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void filterBySubjectCode(ActionEvent event) {
        if (cmb_subjectCode.getSelectionModel().getSelectedItem() != null) {
            String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                    + "FROM session S, managetags T, lecturer L "
                    + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId AND S.subjectcode = '" + cmb_subjectCode.getSelectionModel().getSelectedItem() + "'";
            buildTable(query);
            cmb_lecturer.getSelectionModel().clearSelection();
            cmb_groupId.getSelectionModel().clearSelection();
            cmb_subject.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void filterByGroupId(ActionEvent event) {
        if (cmb_groupId.getSelectionModel().getSelectedItem() != null) {
            String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                    + "FROM session S, managetags T, lecturer L "
                    + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId AND S.sgroupid = '" + cmb_groupId.getSelectionModel().getSelectedItem() + "'";
            buildTable(query);
            cmb_lecturer.getSelectionModel().clearSelection();
            cmb_subjectCode.getSelectionModel().clearSelection();
            cmb_subject.getSelectionModel().clearSelection();
        }
    }

    @FXML
    private void resetFilters(ActionEvent event) {
        String query = "SELECT S.id, S.subjectname, S.subjectcode, S.sgroupid, T.tname, S.duration, S.studentcount, L.name "
                + "FROM session S, managetags T, lecturer L "
                + "WHERE S.tag = T.id AND S.lecturer = L.lecturerId";
        
        buildTable(query);
        cmb_lecturer.getSelectionModel().clearSelection();
        cmb_subjectCode.getSelectionModel().clearSelection();
        cmb_subject.getSelectionModel().clearSelection();
        cmb_groupId.getSelectionModel().clearSelection();
    }

    @FXML
    private void selectClickedLecturer(MouseEvent event) {
        session = tbl_data.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void deleteSelected(MouseEvent event) {
        if (session == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select the recode to delete.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirm deletion");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to delete the session?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.YES) {
                deleteSession();
            }
        }
    }
    
    private void deleteSession() {
        String query = "DELETE FROM session WHERE id = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, session.id.get());
            if (pstmt.executeUpdate() == 1) {
                session = tbl_data.getSelectionModel().getSelectedItem();
                tbl_data.getItems().remove(session);
                session = null;
                Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Session deleted!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Failed");
                alert.setHeaderText(null);
                alert.setContentText("Session is not deleted!");
                alert.showAndWait();
            }

            con.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Failed");
            alert.setHeaderText(null);
            alert.setContentText("Session is not deleted!");
            alert.showAndWait();
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

    private void buildTable(String query) {
        ResultSet resultSet = null;
        try {
            Connection con = dbConnection.getConnection();

            resultSet = con.createStatement().executeQuery(query);

            ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));
            tbl_data.getItems().clear();
            tbl_data.getColumns().clear();

            //Giving readable names to columns
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                TableColumn column = new TableColumn<>();
                switch (resultSet.getMetaData().getColumnName(i + 1)) {
                    case "id":
                        column.setText("ID #");
                        break;
                    case "name":
                        column.setText("Lecturer");
                        break;
                    case "subjectname":
                        column.setText("Subject Name");
                        break;
                    case "subjectcode":
                        column.setText("Subject Code");
                        break;
                    case "sgroupid":
                        column.setText("Group ID");
                        break;
                    case "tname":
                        column.setText("Tag");
                        break;
                    case "duration":
                        column.setText("Duration");
                        break;
                    case "studentcount":
                        column.setText("Student Count");
                        break;
                    default:
                        column.setText(resultSet.getMetaData().getColumnName(i + 1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                        break;
                }
                column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i + 1))); //Setting cell property value to correct variable from Person class.
                tbl_data.getColumns().add(column);
                //Filling up tableView with data
                tbl_data.setItems(dbData);

            }

            con.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Session> data = new ArrayList<>();
        while (resultSet.next()) {
            Session session = new Session();
            session.id.set(resultSet.getInt("id"));
            session.name.set(resultSet.getString("name"));
            session.subjectname.set(resultSet.getString("subjectname"));
            session.subjectcode.set(resultSet.getString("subjectcode"));
            session.sgroupid.set(resultSet.getString("sgroupid"));
            session.tname.set(resultSet.getString("tname"));
            session.duration.set(resultSet.getString("duration"));
            session.studentcount.set(resultSet.getString("studentcount"));
            data.add(session);
        }
        return data;
    }

    public class Session {

        IntegerProperty id = new SimpleIntegerProperty();
        StringProperty subjectname = new SimpleStringProperty();
        StringProperty subjectcode = new SimpleStringProperty();
        StringProperty sgroupid = new SimpleStringProperty();
        StringProperty tname = new SimpleStringProperty();
        StringProperty duration = new SimpleStringProperty();
        StringProperty studentcount = new SimpleStringProperty();
        StringProperty name = new SimpleStringProperty();

        public Session() {
        }

        public Session(int id, String subjectname, String subjectcode, String sgroupid, String tname, String duration, String studentcount, String name) {
            this.id.set(id);
            this.name.set(name);
            this.subjectname.set(subjectname);
            this.subjectcode.set(subjectcode);
            this.sgroupid.set(sgroupid);
            this.tname.set(tname);
            this.duration.set(duration);
            this.studentcount.set(studentcount);
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public StringProperty nameProperty() {
            return name;
        }

        public StringProperty subjectnameProperty() {
            return subjectname;
        }

        public StringProperty subjectcodeProperty() {
            return subjectcode;
        }

        public StringProperty sgroupidProperty() {
            return sgroupid;
        }

        public StringProperty tnameProperty() {
            return tname;
        }

        public StringProperty durationProperty() {
            return duration;
        }

        public StringProperty studentcountProperty() {
            return studentcount;
        }

    }

    public class Lecturer {

        private String id;
        private String name;

        public Lecturer() {
        }

        public Lecturer(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.getName();
        }
    }

    public class Subject {

        private String name;
        private String code;

        public Subject() {
        }

        public Subject(String code, String name) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return this.getName();
        }

    }

}
