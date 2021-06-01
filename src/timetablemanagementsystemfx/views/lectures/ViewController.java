package timetablemanagementsystemfx.views.lectures;

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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import timetablemanagementsystemfx.utils.dbConnection;

public class ViewController implements Initializable {

    private LecturerRow selectedLecturer = null;

    @FXML
    private TableView<LecturerRow> tbl_data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildTable();
    }

    private void buildTable() {
        ResultSet resultSet = null;
        try {
            Connection con = dbConnection.getConnection();
            String query = "SELECT L.lecturerId, L.name, F.facultyName, B.buildingName, C.centerName, D.departmentName, CA.categoryName, LE.levelName, L.rank "
                    + "FROM lecturer L, faculty F, building B, center C, department D, category CA, level LE "
                    + "WHERE L.faculty = F.facultyId AND L.building = B.buildingId AND L.center = C.centerId AND L.department = D.departmentId AND L.category = CA.categoryId AND L.level = LE.level";

            resultSet = con.createStatement().executeQuery(query);

            ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

            //Giving readable names to columns
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                TableColumn column = new TableColumn<>();
                switch (resultSet.getMetaData().getColumnName(i + 1)) {
                    case "lecturerId":
                        column.setText("ID #");
                        break;
                    case "name":
                        column.setText("Name");
                        break;
                    case "facultyName":
                        column.setText("Faculty");
                        break;
                    case "buildingName":
                        column.setText("Building");
                        break;
                    case "centerName":
                        column.setText("Center");
                        break;
                    case "departmentName":
                        column.setText("Department");
                        break;
                    case "categoryName":
                        column.setText("Category");
                        break;
                    case "levelName":
                        column.setText("Level");
                        break;
                    case "rank":
                        column.setText("Rank");
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
        ArrayList<LecturerRow> data = new ArrayList<>();
        while (resultSet.next()) {
            LecturerRow lecturer = new LecturerRow();
            lecturer.lecturerId.set(resultSet.getString("lecturerId"));
            lecturer.name.set(resultSet.getString("name"));
            lecturer.facultyName.set(resultSet.getString("facultyName"));
            lecturer.buildingName.set(resultSet.getString("buildingName"));
            lecturer.centerName.set(resultSet.getString("centerName"));
            lecturer.departmentName.set(resultSet.getString("departmentName"));
            lecturer.categoryName.set(resultSet.getString("categoryName"));
            lecturer.levelName.set(resultSet.getString("levelName"));
            lecturer.rank.set(resultSet.getString("rank"));
            data.add(lecturer);
        }
        return data;
    }

    @FXML
    private void selectClickedLecturer(MouseEvent event) {
        selectedLecturer = tbl_data.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void deleteSelected(MouseEvent event) {
        if (selectedLecturer == null) {
            Alert alert = new Alert(AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please select the recode to delete.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(AlertType.CONFIRMATION, "", ButtonType.YES, ButtonType.NO);
            alert.setTitle("Confirm deletion");
            alert.setHeaderText(null);
            alert.setContentText("Do you want to delete the lecturer?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.YES) {
                deleteLecturer();
            }
        }
    }

    private void deleteLecturer() {
        String query = "DELETE FROM lecturer WHERE lecturerId = ?";
        try {
            Connection con = dbConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, selectedLecturer.lecturerId.get());
            if (pstmt.executeUpdate() == 1) {
                selectedLecturer = tbl_data.getSelectionModel().getSelectedItem();
                tbl_data.getItems().remove(selectedLecturer);
                selectedLecturer = null;
                Alert alert = new Alert(AlertType.INFORMATION, null, ButtonType.OK);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer deleted!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Failed");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer is not deleted!");
                alert.showAndWait();
            }

            con.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR, null, ButtonType.OK);
            alert.setTitle("Failed");
            alert.setHeaderText(null);
            alert.setContentText("Lecturer is not deleted!");
            alert.showAndWait();
        }
    }

    public class LecturerRow {

        StringProperty lecturerId = new SimpleStringProperty();
        StringProperty name = new SimpleStringProperty();
        StringProperty facultyName = new SimpleStringProperty();
        StringProperty buildingName = new SimpleStringProperty();
        StringProperty centerName = new SimpleStringProperty();
        StringProperty departmentName = new SimpleStringProperty();
        StringProperty categoryName = new SimpleStringProperty();
        StringProperty levelName = new SimpleStringProperty();
        StringProperty rank = new SimpleStringProperty();

        public StringProperty lecturerIdProperty() {
            return lecturerId;
        }

        public StringProperty nameProperty() {
            return name;
        }

        public StringProperty facultyNameProperty() {
            return facultyName;
        }

        public StringProperty buildingNameProperty() {
            return buildingName;
        }

        public StringProperty centerNameProperty() {
            return centerName;
        }

        public StringProperty departmentNameProperty() {
            return departmentName;
        }

        public StringProperty categoryNameProperty() {
            return categoryName;
        }

        public StringProperty levelNameProperty() {
            return levelName;
        }

        public StringProperty rankProperty() {
            return rank;
        }

        public LecturerRow() {
        }

        public LecturerRow(String lecturerId, String name, String facultyName, String buildingName, String centerName, String departmentName, String categoryName, String levelName, String rank) {
            this.lecturerId.set(lecturerId);
            this.name.set(name);
            this.facultyName.set(facultyName);
            this.buildingName.set(buildingName);
            this.centerName.set(centerName);
            this.departmentName.set(departmentName);
            this.categoryName.set(categoryName);
            this.levelName.set(levelName);
            this.rank.set(rank);
        }
    }

}
