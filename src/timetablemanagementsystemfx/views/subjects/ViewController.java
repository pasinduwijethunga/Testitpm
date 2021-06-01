package timetablemanagementsystemfx.views.subjects;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import timetablemanagementsystemfx.utils.dbConnection;

public class ViewController implements Initializable {

    private SubjectRow selectedSubject = null;
    
    @FXML
    private TableView<SubjectRow> tbl_data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        buildTable();
        
    }    

    
    private void buildTable() {
        ResultSet resultSet = null;
        try {
            Connection con = dbConnection.getConnection();
            String query = "SELECT subjectCode, subjectName, offeredYear, offeredSemester, noOfLecHours, noOfTutHours, noOfLabHours, noOfEvaHours FROM subject";
            resultSet = con.createStatement().executeQuery(query);
            ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

            //Giving readable names to columns
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                TableColumn column = new TableColumn<>();
                switch (resultSet.getMetaData().getColumnName(i + 1)) {
                    case "subjectCode":
                        column.setText("Subject Code");
                        break;
                    case "subjectName":
                        column.setText("Subject Name");
                        break;
                    case "offeredYear":
                        column.setText("Offered Year");
                        break;
                    case "offeredSemester":
                        column.setText("Offered Semester");
                        break;
                    case "noOfLecHours":
                        column.setText("No of Lec Hours");
                        break;
                    case "noOfTutHours":
                        column.setText("No of Tut Hours");
                        break;
                    case "noOfLabHours":
                        column.setText("No of Lab Hours");
                        break;
                    case "noOfEvaHours":
                        column.setText("No of Eva Hours");
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

    //extracting data from ResulSet to ArrayList
    private ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<SubjectRow> data = new ArrayList<>();
        while (resultSet.next()) {
            SubjectRow subject = new SubjectRow();
            subject.subjectCode.set(resultSet.getString("subjectCode"));
            subject.subjectName.set(resultSet.getString("subjectName"));
            subject.offeredYear.set(resultSet.getString("offeredYear"));
            subject.offeredSemester.set(resultSet.getString("offeredSemester"));
            subject.noOfLecHours.set(resultSet.getString("noOfLecHours"));
            subject.noOfTutHours.set(resultSet.getString("noOfTutHours"));
            subject.noOfLabHours.set(resultSet.getString("noOfLabHours"));
            subject.noOfEvaHours.set(resultSet.getString("noOfEvaHours"));
            data.add(subject);
        }
        return data;
    } 

    @FXML
    private void selectClickedLecturer(MouseEvent event) {
        selectedSubject = tbl_data.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void deleteSelected(MouseEvent event) {
        if (selectedSubject == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select the recode to delete.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirm deletion");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to delete the Subject?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.YES) {
                deleteSubject();
            }
        }
    }
        
    private void deleteSubject() {
        String query = "DELETE FROM subject WHERE subjectCode = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, selectedSubject.subjectCode.get());
            if (pstmt.executeUpdate() == 1) {
                selectedSubject = tbl_data.getSelectionModel().getSelectedItem();
                tbl_data.getItems().remove(selectedSubject);
                selectedSubject = null;
                Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Subject deleted!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Failed");
                alert.setHeaderText(null);
                alert.setContentText("Subject is not deleted!");
                alert.showAndWait();
            }

            con.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Failed");
            alert.setHeaderText(null);
            alert.setContentText("Lecturer is not deleted!");
            alert.showAndWait();
        }
    }

    public class SubjectRow {

        StringProperty subjectCode = new SimpleStringProperty();
        StringProperty subjectName = new SimpleStringProperty();
        StringProperty offeredYear = new SimpleStringProperty();
        StringProperty offeredSemester = new SimpleStringProperty();
        StringProperty noOfLecHours = new SimpleStringProperty();
        StringProperty noOfTutHours = new SimpleStringProperty();
        StringProperty noOfLabHours = new SimpleStringProperty();
        StringProperty noOfEvaHours = new SimpleStringProperty();

        public StringProperty subjectCodeProperty() {
            return subjectCode;
        }

        public StringProperty subjectNameProperty() {
            return subjectName;
        }

        public StringProperty offeredYearProperty() {
            return offeredYear;
        }

        public StringProperty offeredSemesterProperty() {
            return offeredSemester;
        }

        public StringProperty noOfLecHoursProperty() {
            return noOfLecHours;
        }

        public StringProperty noOfTutHoursProperty() {
            return noOfTutHours;
        }

        public StringProperty noOfLabHoursProperty() {
            return noOfLabHours;
        }

        public StringProperty noOfEvaHoursProperty() {
            return noOfEvaHours;
        }

        public SubjectRow() {
        }

        public SubjectRow(String subjectCode, String subjectName, String offeredYear, String offeredSemester, String noOfLecHours, String noOfTutHours, String noOfLabHours, String noOfEvaHours) {
            this.subjectCode.set(subjectCode);
            this.subjectName.set(subjectName);
            this.offeredYear.set(offeredYear);
            this.offeredSemester.set(offeredSemester);
            this.noOfLecHours.set(noOfLecHours);
            this.noOfTutHours.set(noOfTutHours);
            this.noOfLabHours.set(noOfLabHours);
            this.noOfEvaHours.set(noOfEvaHours);
        }
    }
}
