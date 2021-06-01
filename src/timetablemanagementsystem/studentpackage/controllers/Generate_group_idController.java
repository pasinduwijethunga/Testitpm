/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.studentpackage.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import timetablemanagementsystem.studentpackage.models.generateid;

/**
 * FXML Controller class
 *
 * @author Kavindi Gayaththri
 */
public class Generate_group_idController implements Initializable {

    @FXML
    private Label bar4;
    @FXML
    private Label label4;
    @FXML
    private Button cancel4;
    @FXML
    private Button delete4;
    @FXML
    private Button update4;
    @FXML
    private TableView<generateid> table4;
    @FXML
    private TextField txf1;
    @FXML
    private TextField txf2;
    @FXML
    private TextField txf3;
    @FXML
    private TextField txf4;
    @FXML
    private TextField txf5;
    @FXML
    private TextField txf6;
    private Button generateid;
    @FXML
    private Button search;
    @FXML
    private TextField searchbar;
    @FXML
    private TableColumn<generateid, String> colid1;
    @FXML
    private TableColumn<generateid, String> col2;
    @FXML
    private TableColumn<generateid, String> col3;
    @FXML
    private TableColumn<generateid, String> col4;
    @FXML
    private TableColumn<generateid, String> col5;
    @FXML
    private TableColumn<generateid, String> col6;
    @FXML
    private TableColumn<generateid,String> col7;

    /**
     * Initializes the controller class.
     */
    String searchid = null;
    @FXML
    private Button generate;
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
        // TODO
        showgenerateid();
    }    

    @FXML
    private void handleButtonAction(ActionEvent event) throws SQLException {
    if(event.getSource() == generate){
        InsertRecord();
        CancelRecord();
    }else if(event.getSource() == update4){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            UpdateRecord();
            CancelRecord();
        }
    }else if (event.getSource() == delete4){
        if(searchid == null){
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }else{
            deleteButton();
            CancelRecord();
        }
    }else if (event.getSource() == cancel4){
        CancelRecord();
    }else if (event.getSource() == search){
        if (!(searchbar.getText().isEmpty())){
            SearchRecord();
        }
        else{
            searchbar.setPromptText("PLEASE ENTER ID TO SEARCH");
        }
    }
        
    }
    
    public Connection getconnection(){
         Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
}
    
      public ObservableList<generateid> getgenerateidlist(){
        ObservableList<generateid> Generateidlist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM Generateid";
        Statement st;
        ResultSet rs;
          
        try {
            
        st = conn.createStatement();
        rs = st.executeQuery(query);
        generateid Generateid;
        while(rs.next()){
            Generateid = new generateid(rs.getString("id"), rs.getString("year_sem"), rs.getString("programe"), rs.getString("gnum"), rs.getString("sgnum"), rs.getString("groupid") ,rs.getString("subgid"));
            Generateidlist.add(Generateid);
            
        }
    }catch (Exception ex){
        ex.printStackTrace();
    }
        return Generateidlist;
   }
    public void showgenerateid(){
        ObservableList<generateid> list = getgenerateidlist();
        colid1.setCellValueFactory(new PropertyValueFactory<generateid ,String>("id"));
        col2.setCellValueFactory(new PropertyValueFactory<generateid ,String>("year_sem"));
        col3.setCellValueFactory(new PropertyValueFactory<generateid ,String>("programe"));
        col4.setCellValueFactory(new PropertyValueFactory<generateid ,String>("gnum"));
        col5.setCellValueFactory(new PropertyValueFactory<generateid ,String>("sgnum"));
        col6.setCellValueFactory(new PropertyValueFactory<generateid ,String>("groupid"));
        col7.setCellValueFactory(new PropertyValueFactory<generateid ,String>("subgid"));  
        
        table4.setItems(list);
        
    }
    private void InsertRecord(){
        String query = "INSERT INTO generateid(year_sem,programe,gnum,sgnum,groupid,subgid) VALUES('"+txf1.getText()+"','"+txf2.getText()+"','"+txf3.getText()+"','"+txf4.getText()+"','"+txf5.getText()+"','"+txf6.getText()+"')";
        executeQuery(query);
        showgenerateid();
        searchid = null;
    }
    private void UpdateRecord(){
        String query = "UPDATE generateid SET year_sem = '" + txf1.getText() + "' , programe = '" + txf2.getText() + "', gnum = '" + txf3.getText() + "', sgnum = '" + txf4.getText()+ "',groupid = '"+ txf5.getText() +"', subgid = '" + txf6.getText() +"' where id ="+searchid+"";
        executeQuery(query);
        showgenerateid();
        searchid = null;
    }
    private void deleteButton(){
        String query = "DELETE FROM generateid where id ="+searchid+"";
        executeQuery(query);
        showgenerateid();
        searchid = null;
    }
    private void CancelRecord(){
        
        txf1.setText("");
        txf2.setText("");
        txf3.setText("");
        txf4.setText("");
        txf5.setText("");
        txf6.setText("");
        searchbar.setText("");
        
        showgenerateid();
    }
            
    private void executeQuery(String query) {
        Connection conn = getconnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }

    private void SearchRecord() throws SQLException {
        
        searchid = searchbar.getText();
        
        ObservableList<generateid> Generateidlist = FXCollections.observableArrayList();
        Connection conn = getconnection();
        String query = "SELECT * FROM Generateid where id="+searchid+"";
        Statement st;
        ResultSet rs;
            
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
           
        while(rs.next()){
            txf1.setText(rs.getString("year_sem"));
            txf2.setText(rs.getString("programe"));
            txf3.setText(rs.getString("gnum"));
            txf4.setText(rs.getString("sgnum"));
            txf5.setText(rs.getString("groupid"));
            txf6.setText(rs.getString("subgid"));
        }
        
        }catch (Exception ex){
        ex.printStackTrace();
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