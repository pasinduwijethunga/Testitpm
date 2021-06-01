package timetablemanagementsystemfx.views.lectures;

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
import timetablemanagementsystemfx.models.Building;
import timetablemanagementsystemfx.models.Category;
import timetablemanagementsystemfx.models.Center;
import timetablemanagementsystemfx.models.Department;
import timetablemanagementsystemfx.models.Faculty;
import timetablemanagementsystemfx.models.LecturerModel;
import timetablemanagementsystemfx.models.Level;
import timetablemanagementsystemfx.utils.dbConnection;

public class EditController implements Initializable {

    @FXML
    private ComboBox<Category> cmb_category;
    @FXML
    private ComboBox<Level> cmb_level;
    @FXML
    private ComboBox<LecturerModel> cmb_lecturerId;
    @FXML
    private TextField txt_name;
    @FXML
    private ComboBox<Faculty> cmb_faculty;
    @FXML
    private ComboBox<Building> cmb_building;
    @FXML
    private ComboBox<Center> cmb_center;
    @FXML
    private ComboBox<Department> cmb_department;
    @FXML
    private TextField txt_rank;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillLecturerCombo();
        fillBuildingCombo();
        fillCategoryCombo();
        fillCenterCombo();
        fillFacultyCombo();
        fillLevelCombo();
    }

    private void fillLecturerCombo() {
        String sql = "SELECT * FROM lecturer";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_lecturerId.getItems().clear();
            ObservableList<LecturerModel> lecturers = FXCollections.observableArrayList();
            while (rs.next()) {
                lecturers.add(new LecturerModel(rs.getString("lecturerId"), rs.getString("name"), rs.getString("faculty"), rs.getString("building"), rs.getString("center"), rs.getString("department"), rs.getString("category"), rs.getString("level"), rs.getString("rank")));
            }
            cmb_lecturerId.setItems(lecturers);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillFacultyCombo() {
        String sql = "SELECT * FROM faculty";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_faculty.getItems().clear();
            ObservableList<Faculty> faculties = FXCollections.observableArrayList();
            while (rs.next()) {
                faculties.add(new Faculty(rs.getString("facultyId"), rs.getString("facultyName")));
            }
            cmb_faculty.setItems(faculties);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillBuildingCombo() {
        String sql = "SELECT * FROM building";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_building.getItems().clear();
            ObservableList<Building> buildings = FXCollections.observableArrayList();
            while (rs.next()) {
                buildings.add(new Building(rs.getString("buildingId"), rs.getString("buildingName")));
            }
            cmb_building.setItems(buildings);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCenterCombo() {
        String sql = "SELECT * FROM center";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_center.getItems().clear();
            ObservableList<Center> centers = FXCollections.observableArrayList();
            while (rs.next()) {
                centers.add(new Center(rs.getString("centerId"), rs.getString("centerName"), rs.getString("address")));
            }
            cmb_center.setItems(centers);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillDepartmentCombo(String facultyId) {
        String sql = "SELECT * FROM department D WHERE D.faculty = '" + facultyId + "'";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_department.getItems().clear();
            ObservableList<Department> departments = FXCollections.observableArrayList();
            while (rs.next()) {
                departments.add(new Department(rs.getString("departmentId"), rs.getString("departmentName"), rs.getString("faculty")));
            }
            cmb_department.setItems(departments);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillCategoryCombo() {
        String sql = "SELECT * FROM category";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_category.getItems().clear();
            ObservableList<Category> categories = FXCollections.observableArrayList();
            while (rs.next()) {
                categories.add(new Category(rs.getString("categoryId"), rs.getString("categoryName")));
            }
            cmb_category.setItems(categories);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillLevelCombo() {
        String sql = "SELECT * FROM level";
        try {
            Connection con = dbConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery(sql);
            cmb_level.getItems().clear();
            ObservableList<Level> levels = FXCollections.observableArrayList();
            while (rs.next()) {
                levels.add(new Level(rs.getInt("level"), rs.getString("levelName")));
            }
            cmb_level.setItems(levels);

            con.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetForm() {
        txt_name.setText("");
        txt_rank.setText("");
        cmb_building.getSelectionModel().clearSelection();
        cmb_category.getSelectionModel().clearSelection();
        cmb_center.getSelectionModel().clearSelection();
        cmb_faculty.getSelectionModel().clearSelection();
        cmb_level.getSelectionModel().clearSelection();
        cmb_department.getSelectionModel().clearSelection();
        cmb_lecturerId.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void loadLecturer(ActionEvent event) {
        if (cmb_lecturerId.getSelectionModel().getSelectedItem() != null) {
            LecturerModel lec = cmb_lecturerId.getSelectionModel().getSelectedItem();
            txt_name.setText(lec.getName());
            txt_rank.setText(lec.getRank());

            cmb_faculty.getItems().stream().filter((next) -> (next.getFacultyId() == null ? lec.getFaculty() == null : next.getFacultyId().equals(lec.getFaculty()))).forEachOrdered((next) -> {
                cmb_faculty.getSelectionModel().select(next);
            });

            cmb_building.getItems().stream().filter((next) -> (next.getBuildingId() == null ? lec.getBulding() == null : next.getBuildingId().equals(lec.getBulding()))).forEachOrdered((next) -> {
                cmb_building.getSelectionModel().select(next);
            });

            cmb_center.getItems().stream().filter((next) -> (next.getCenterId() == null ? lec.getCenter() == null : next.getCenterId().equals(lec.getCenter()))).forEachOrdered((next) -> {
                cmb_center.getSelectionModel().select(next);
            });

            cmb_department.getItems().stream().filter((next) -> (next.getDepartmentId() == null ? lec.getDepartment() == null : next.getDepartmentId().equals(lec.getDepartment()))).forEachOrdered((next) -> {
                cmb_department.getSelectionModel().select(next);
            });

            cmb_category.getItems().stream().filter((next) -> (next.getCategoryId() == null ? lec.getCategory() == null : next.getCategoryId().equals(lec.getCategory()))).forEachOrdered((next) -> {
                cmb_category.getSelectionModel().select(next);
            });

            cmb_level.getItems().stream().filter((next) -> (next.getLevel() == Integer.parseInt(lec.getLevel()))).forEachOrdered((next) -> {
                cmb_level.getSelectionModel().select(next);
            });
        }
    }

    @FXML
    private void loadDepartments(ActionEvent event) {
        if (cmb_faculty.getSelectionModel().getSelectedItem() != null) {
            Faculty faculty = cmb_faculty.getSelectionModel().getSelectedItem();
            fillDepartmentCombo(faculty.getFacultyId());
        }
    }

    @FXML
    private void reset(MouseEvent event) {
        resetForm();
    }

    @FXML
    private void save(MouseEvent event) {
        if (!"".equals(txt_name.getText().trim())
                && !"".equals(txt_rank.getText().trim())
                && cmb_building.getSelectionModel().getSelectedItem() != null
                && cmb_category.getSelectionModel().getSelectedItem() != null
                && cmb_center.getSelectionModel().getSelectedItem() != null
                && cmb_department.getSelectionModel().getSelectedItem() != null
                && cmb_faculty.getSelectionModel().getSelectedItem() != null
                && cmb_level.getSelectionModel().getSelectedItem() != null
                && cmb_lecturerId.getSelectionModel().getSelectedItem() != null) {
            String sql = "UPDATE lecturer SET `name` = ?, `faculty` = ?, `building` = ?, `center` = ?, `department` = ?, `category` = ?, `level` = ?, `rank` = ? WHERE `lecturerId` = ?";
            try {
                Connection con = dbConnection.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, txt_name.getText().trim());
                pstmt.setString(2, cmb_faculty.getSelectionModel().getSelectedItem().getFacultyId());
                pstmt.setString(3, cmb_building.getSelectionModel().getSelectedItem().getBuildingId());
                pstmt.setString(4, cmb_center.getSelectionModel().getSelectedItem().getCenterId());
                pstmt.setString(5, cmb_department.getSelectionModel().getSelectedItem().getDepartmentId());
                pstmt.setString(6, cmb_category.getSelectionModel().getSelectedItem().getCategoryId());
                pstmt.setInt(7, cmb_level.getSelectionModel().getSelectedItem().getLevel());
                pstmt.setString(8, txt_rank.getText().trim());
                pstmt.setString(9, cmb_lecturerId.getSelectionModel().getSelectedItem().getLecturerId());

                if (pstmt.executeUpdate() == 1) {
                    resetForm();
                    fillLecturerCombo();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Lecturer updated");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Lecturer not updated!");
                    alert.showAndWait();
                }

                con.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Lecturer not updated!");
                alert.showAndWait();
                e.printStackTrace();
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
