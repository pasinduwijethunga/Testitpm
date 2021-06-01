package timetablemanagementsystemfx.views.subjects;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import timetablemanagementsystemfx.utils.dbConnection;

public class InsertController implements Initializable {

    @FXML
    private TextField txt_numberOfLabHours;
    @FXML
    private TextField txt_subjectCode;
    @FXML
    private TextField txt_subjectName;
    @FXML
    private ComboBox<String> cmb_offeredYear;
    @FXML
    private TextField txt_numberOfLecturerHours;
    @FXML
    private TextField txt_numberOfTutorialHours;
    @FXML
    private TextField txt_numberOfEvaluationHours;
    @FXML
    private ComboBox<String> cmb_offeredSemester;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fillOfferedYearCombo();
        fillOfferedSemesterCombo();
    }    
    
//    private void fillOfferedYearCombo() {
//        try {
//            cmb_offeredYear.getItems().clear();
//            ObservableList<String> offeredYear = FXCollections.observableArrayList();
//            for(int i = 2000; i < 3000; i++) {
//
//                offeredYear.add(String.valueOf(i));
//                
//            }
//            cmb_offeredYear.setItems(offeredYear);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
    private void fillOfferedYearCombo() {
        try {
            cmb_offeredYear.getItems().clear();
            ObservableList<String> offeredYear = FXCollections.observableArrayList();
            offeredYear.add("1st Year ");
            offeredYear.add("2nd Year ");
            offeredYear.add("3rd Year ");
            offeredYear.add("4th Year ");
            
            cmb_offeredYear.setItems(offeredYear);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fillOfferedSemesterCombo() {
        try {
            cmb_offeredSemester.getItems().clear();
            ObservableList<String> offeredSemester = FXCollections.observableArrayList();
            offeredSemester.add("1st Semester");
            offeredSemester.add("2nd Semester");
           
            
            cmb_offeredSemester.setItems(offeredSemester);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void reset(MouseEvent event) {
        resetForm();
    }

    @FXML
    private void save(MouseEvent event) {
        if (!"".equals(txt_subjectCode.getText().trim())
                && !"".equals(txt_subjectName.getText().trim())
                && !"".equals(txt_numberOfEvaluationHours.getText().trim())
                && !"".equals(txt_numberOfLabHours.getText().trim())
                && !"".equals(txt_numberOfTutorialHours.getText().trim())
                && !"".equals(txt_numberOfLecturerHours.getText().trim())
                && cmb_offeredYear.getSelectionModel().getSelectedItem() != null
                && cmb_offeredSemester.getSelectionModel().getSelectedItem() != null) {

            try {

                Connection con = dbConnection.getConnection();
                String sql = "INSERT INTO subject(`subjectCode`, `subjectName`, `offeredYear`, `offeredSemester`, `noOfLecHours`, `noOfTutHours`, `noOfLabHours`, `noOfEvaHours`) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, txt_subjectCode.getText().trim());
                pstmt.setString(2, txt_subjectName.getText().trim());
                pstmt.setString(3, cmb_offeredYear.getSelectionModel().getSelectedItem());
                pstmt.setString(4, cmb_offeredSemester.getSelectionModel().getSelectedItem());
                pstmt.setInt(5, Integer.parseInt(txt_numberOfLecturerHours.getText().trim()));
                pstmt.setInt(6, Integer.parseInt(txt_numberOfTutorialHours.getText().trim()));
                pstmt.setInt(7, Integer.parseInt(txt_numberOfLabHours.getText().trim()));
                pstmt.setInt(8, Integer.parseInt(txt_numberOfEvaluationHours.getText().trim()));

                if (pstmt.executeUpdate() == 1) {
                    resetForm();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, null, ButtonType.OK);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject saved");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                    alert.setTitle("Failed");
                    alert.setHeaderText(null);
                    alert.setContentText("Subject not saved!");
                    alert.showAndWait();
                }

            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, null, ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Subject not saved!");
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
        txt_subjectCode.setText("");
        txt_subjectName.setText("");
        txt_numberOfLabHours.setText("");
        txt_numberOfEvaluationHours.setText("");
        txt_numberOfLecturerHours.setText("");
        txt_numberOfTutorialHours.setText("");
        cmb_offeredYear.getSelectionModel().clearSelection();
        cmb_offeredSemester.getSelectionModel().clearSelection();
    }   
}
