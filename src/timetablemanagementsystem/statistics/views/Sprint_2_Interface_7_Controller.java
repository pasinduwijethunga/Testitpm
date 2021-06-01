/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.statistics.views;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author thina
 */
public class Sprint_2_Interface_7_Controller implements Initializable {

    @FXML
    private Button Sup;
    @FXML
    private TableView<Time> tbltime;
    @FXML
    private TableColumn<Time,String> b1;
    @FXML
    private TableColumn<Time,String> r1;
    @FXML
    private TableColumn<Time, String> d1;
    @FXML
    private TableColumn<Time,String> s1;
    @FXML
    private TableColumn<Time, String> e1;
    @FXML
    private ComboBox<String> comboboxroom;
    @FXML
    private ComboBox<String> comboboxday;
    @FXML
    private ComboBox<String> comboboxstart;
    @FXML
    private ComboBox<String> comboxend;
    @FXML
    private ComboBox<String> comboxbuilding;
    
     
    
    
    
    /**
     * Initializes the controller class.
     */
    ObservableList<String> building = FXCollections.observableArrayList();
    @FXML
    private Button btndel;
    @FXML
    private Button Home;
    @FXML
    private MenuButton sm;
    @FXML
    private MenuItem sm1;
    @FXML
    private MenuItem sm2;
    @FXML
    private MenuItem sm3;
    @FXML
    private MenuItem sm4;
    @FXML
    private MenuItem sm5;
    @FXML
    private MenuItem sm6;
    @FXML
    private MenuItem sm7;
    @FXML
    private MenuItem sm8;
    @FXML
    private MenuButton sl;
    @FXML
    private MenuItem sl1;
    @FXML
    private MenuItem sl2;
    @FXML
    private MenuItem sl3;
    @FXML
    private MenuItem sl4;
    @FXML
    private MenuItem sl5;
    @FXML
    private MenuItem sl6;
    @FXML
    private MenuItem sl7;
    @FXML
    private MenuItem sl8;
    @FXML
    private MenuItem sl9;
    @FXML
    private MenuButton slo;
    @FXML
    private MenuItem slo1;
    @FXML
    private MenuItem slo2;
    @FXML
    private MenuItem slo3;
    @FXML
    private MenuItem slo4;
    @FXML
    private MenuItem slo5;
    @FXML
    private MenuItem slo6;
    @FXML
    private MenuItem slo7;
    @FXML
    private MenuButton sdm;
    @FXML
    private MenuItem sdm1;
    @FXML
    private MenuItem sdm2;
    @FXML
    private MenuItem sdm3;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxroom.getItems().addAll(getRoom());
        comboboxday.getItems().addAll(getDay());
        comboboxstart.getItems().addAll(getStartTime());
        comboxend.getItems().addAll(getEndtime());
        comboxbuilding.getItems().addAll(getBuilding());
        populate();

        btndel.setOnAction((event) -> {
            newTime();
            populate();
        });

        tbltime.setContextMenu(createContextMenu());
    }

    private List<String> getRoom() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM room");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("tfRoom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getDay() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM parallelsession");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(String.valueOf(resS.getString("day")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getStartTime() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM parallelsession");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("startingtime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<String> getEndtime() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM parallelsession");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("endtime"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
 
    private List<String> getBuilding() {
        List<String> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();

        try {
            prepS = connection.prepareStatement("SELECT * FROM building");
            resS = prepS.executeQuery();

            while (resS.next()) {
                list.add(resS.getString("buildingName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private List<Time> getTime() {
        List<Time> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement prepS = null;
        ResultSet resS = null;
        connection = getConnection();
        Time time = null;

        try {
            prepS = connection.prepareStatement("SELECT * FROM reservedtime");
            resS = prepS.executeQuery();

            while (resS.next()) {
                time = new Time();
                time.setId(resS.getInt("id"));
                time.setBuilding(resS.getString("Building"));
                time.setRoom(resS.getString("Room"));
                time.setDay(resS.getString("day"));
                time.setStartTime(resS.getString("StartTime"));
                time.setEndtime(resS.getString("Endtime"));
              

                list.add(time);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                resS.close();
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    private void newTime() {
        Connection connection = null;
        PreparedStatement prepS = null;
        connection = getConnection();
        Time time = null;

        try {
            prepS = connection.prepareStatement("INSERT INTO reservedtime(Building, Room, day, StartTime, Endtime) VALUES(?, ?, ?, ?, ? )");

            prepS.setString(1, comboboxroom.getValue());
            prepS.setString(2, comboboxday.getValue());
            prepS.setString(3, comboboxstart.getValue());
            prepS.setString(4, comboxend.getValue());
            prepS.setString(5, comboxbuilding.getValue());
           
            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                prepS.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void populate() {
    
        b1.setCellValueFactory(new PropertyValueFactory<>("Building"));
        r1.setCellValueFactory(new PropertyValueFactory<>("Room"));
        d1.setCellValueFactory(new PropertyValueFactory<>("day"));
        s1.setCellValueFactory(new PropertyValueFactory<>("StartTime"));
        e1.setCellValueFactory(new PropertyValueFactory<>("Endtime"));

        tbltime.getItems().setAll(getTime());
    }

    private ContextMenu createContextMenu() {
        ContextMenu cMenu = new ContextMenu();

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction((event) -> {
            deleteTimeWindow();
        });

        cMenu.getItems().addAll(delete);

        return cMenu;
    }

    private void deleteTimeWindow() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmatio Box");
        alert.setHeaderText("Remove Allocation");
        alert.setContentText("Do you want to remove the time?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            deleteTime(tbltime.getSelectionModel().getSelectedItem().getId());
            populate();
        }
    }

    private void deleteTime(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement prepS = connection.prepareStatement("DELETE FROM reservedtime WHERE id = ?");
            prepS.setInt(1, id);

            prepS.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Sprint_2_Interface_7_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    @FXML
    private void handleMenuStudent(ActionEvent event) throws IOException {
        
        if(event.getSource() == Home){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/Home.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/academicdetails.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/program_details.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/group_details.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm4){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/managetags.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm5){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/generate_group_id.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm6){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/consecutive_session.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm7){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/Parallel_Session.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sm8){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/overlapping.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        
    }

    @FXML
    private void handleMenuLecture(ActionEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystemfx/views/dashboard.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }

    @FXML
    private void handleMenuLocation(ActionEvent event) throws IOException {
        if(event.getSource() == slo1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/StudentStatistic.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/StaticforLectureSubject.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/RoomforSubTagLecSes.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo4){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/RoomForgroup.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo5){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/concesession.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo6){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/timecannotreserved.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == slo7){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/statistics/views/buildingandroom.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) slo).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        
    }

    @FXML
    private void handleMenuDay(ActionEvent event) throws IOException {
        if(event.getSource() == sdm1){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/WorkingDaysAndHours.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sdm2){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/SessionAndNotAvailableTimeAllocation.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
        else if(event.getSource() == sdm3){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/workingDaysAndHours/views/SessionRoom.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) sdm).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
        }
    }

    
    
}
