/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.studentpackage.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kavindi Gayaththri
 */
public class StudentdashboardController implements Initializable {

    @FXML
    private Button button_academic;
    @FXML
    private Button button_genGID;
    @FXML
    private Button button_tab;
    @FXML
    private Button button_program;
    @FXML
    private Button button_group;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource() == button_academic){
            Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/academicdetails.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
            
    }else if(event.getSource() == button_genGID){
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/generate_group_id.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
    
    }else if(event.getSource() == button_tab){
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/managetags.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
    
    }else if(event.getSource() == button_program){
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/program_details.fxml"));
            Scene home_page_scene = new Scene(home_page_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.hide();
            app_stage.setScene(home_page_scene);
            app_stage.show();
    
    }else if(event.getSource() == button_group){
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/group_details.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    
    }
    }
    
}
