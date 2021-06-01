/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.workingDaysAndHours.views;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
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

import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Isuru
 */
public class SessionAndNotAvailableTimeAllocationController implements Initializable {

    @FXML
    private ComboBox<String> comboLec;
    @FXML
    private ComboBox<String> comboGroup;
    @FXML
    private ComboBox<String> comboSubGroup;
    @FXML
    private TextField itTime;
    
    String searchid = null;
    ObservableList<String> lec  = FXCollections.observableArrayList();
    ObservableList<String> group  = FXCollections.observableArrayList();
    ObservableList<String> subGroup  = FXCollections.observableArrayList();
    ObservableList<String> subject  = FXCollections.observableArrayList();
    @FXML
    private TableColumn<LecturerGet, String> colDuration;
    @FXML
    private TableColumn<LecturerGet, String> colLecture;
    @FXML
    private TableColumn<LecturerGet, String> colGroup;
    @FXML
    private TableColumn<LecturerGet, String> colSub;
    @FXML
    private TableColumn<LecturerGet, String> colSession;
    
  
    @FXML
    private TableView<LecturerGet> tvDuration;
    @FXML
    private TableColumn<LecturerGet, String> colSubject;
    @FXML
    private ComboBox<String> comboSubject;
    @FXML
    private Button btnCheck;
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
        ShowLecture();
        ShowGroup();
        ShowSubGroup();
        ShowSession();
    }    
    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable", "root", "");
            return conn;
        }catch(Exception ex){
            System.out.println("Error" +ex.getMessage());
            return null;
        }
    }
    //Get Lecture
    public void getLectureList(){
        Connection conn = getConnection();
        String query = "Select name From lecturer ";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Session session;
            while(rs.next()){
                session = new Session (rs.getString("name"));
                lec.add(rs.getString("name"));

                 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
     public void ShowLecture(){
        getLectureList();
         
        comboLec.setItems(lec);
         
         
    }
     
     //Get Group
     
     public void getGroupList(){
        Connection conn = getConnection();
        String query = "Select year_sem From groupdetails ";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Session session;
            while(rs.next()){
                session = new Session (rs.getString("year_sem"));
                group.add(rs.getString("year_sem"));

                 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
     public void ShowGroup(){
        getGroupList();
         
        comboGroup.setItems(group);
         
         
    }
     
     
    //Get Sub Group
     
     public void getSubGroupList(){
        Connection conn = getConnection();
        String query = "Select sgnum From groupdetails ";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Session session;
            while(rs.next()){
                session = new Session (rs.getString("sgnum"));
                subGroup.add(rs.getString("sgnum"));

                 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
     public void ShowSubGroup(){
        getSubGroupList();
         
        comboSubGroup.setItems(subGroup);
         
         
    }
     
    //session
     
     public void getSessionList(){
        Connection conn = getConnection();
        String query = "Select subjectName From subject ";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Session session;
            while(rs.next()){
                session = new Session (rs.getString("subjectName"));
                subject.add(rs.getString("subjectName"));

                 
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }
     public void ShowSession(){
        getSessionList();
         
        comboSubject.setItems(subject);
         
         
    }
     
     
     
     private void executeQuery(String query) {
        Connection conn  = getConnection();
        Statement st;
        try{
            st = conn.createStatement();
            st.execute(query);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
     
     public ObservableList<LecturerGet>getDurationList(){
        String lecturename = comboLec.getValue();
        ObservableList<LecturerGet>lecturerGetList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT duration, lecturename, yearsem, sgroupid, startingtime,subjectname1 "
                + "FROM  parallelsession p, lecturer l  "
                + "where p.lecturename ='"+lecturename+"' and l.name='"+lecturename+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            LecturerGet lecturerGet;
            while(rs.next()){
                lecturerGet = new LecturerGet (rs.getString("duration"), rs.getString("lecturename"),
                        rs.getString("yearsem"),rs.getString("sgroupid"),rs.getString("startingtime"),rs.getString("subjectname1"));
                lecturerGetList.add(lecturerGet);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lecturerGetList;
    }
     public void ShowDuration(){
         ObservableList<LecturerGet> list = getDurationList();
         
         colDuration.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("duration"));
         colLecture.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("lecturename"));
         colGroup.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("yearsem"));
         colSub.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("sgroupid"));
         colSession.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("startingtime"));
         colSubject.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("subjectname1"));
         
         
         tvDuration.setItems(list);
         
    }
     
     //show groups
     
     public ObservableList<LecturerGet>getSelectGroupList(){
        String yearsem = comboGroup.getValue();
        ObservableList<LecturerGet>lecturerGetList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT duration, lecturename, yearsem, sgroupid, startingtime,subjectname1 "
                + "FROM parallelsession p, groupdetails g "
                + "where p.yearsem ='"+yearsem+"' and g.year_sem='"+yearsem+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            LecturerGet lecturerGet;
            while(rs.next()){
                lecturerGet = new LecturerGet (rs.getString("duration"), rs.getString("lecturename"),
                        rs.getString("yearsem"),rs.getString("sgroupid"),rs.getString("startingtime"),rs.getString("subjectname1"));
                lecturerGetList.add(lecturerGet);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lecturerGetList;
    }
     public void ShowSelectGroup(){
         ObservableList<LecturerGet> list = getSelectGroupList();
         
         colDuration.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("duration"));
         colLecture.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("lecturename"));
         colGroup.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("yearsem"));
         colSub.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("sgroupid"));
         colSession.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("startingtime"));
         colSubject.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("subjectname1"));
         
         
         tvDuration.setItems(list);
         
    }
     
     //show Sub groups
     
     public ObservableList<LecturerGet>getSelectSubGroupList(){
        String sgroupid = comboSubGroup.getValue();
        ObservableList<LecturerGet>lecturerGetList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query ="SELECT duration, lecturename, yearsem, sgroupid, startingtime,subjectname1 "
                + "FROM parallelsession p, groupdetails g "
                + "where p.sgroupid ='"+sgroupid+"' and g.sgnum='"+sgroupid+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            LecturerGet lecturerGet;
            while(rs.next()){
                lecturerGet = new LecturerGet (rs.getString("duration"), rs.getString("lecturename"),
                        rs.getString("yearsem"),rs.getString("sgroupid"),rs.getString("startingtime"),rs.getString("subjectname1"));
                lecturerGetList.add(lecturerGet);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lecturerGetList;
    }
     public void ShowSelectSubGroup(){
         ObservableList<LecturerGet> list = getSelectSubGroupList();
         
         colDuration.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("duration"));
         colLecture.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("lecturename"));
         colGroup.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("yearsem"));
         colSub.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("sgroupid"));
         colSession.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("startingtime"));
         colSubject.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("subjectname1"));
         
         
         tvDuration.setItems(list);
         
    }
     
     //show Sub groups
     
     public ObservableList<LecturerGet>getSelectSubjectList(){
        String subjectname1 = comboSubject.getValue();
        ObservableList<LecturerGet>lecturerGetList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT duration, lecturename, yearsem, sgroupid, startingtime,subjectname1 "
                + "FROM parallelsession p, subject s "
                + "where p.subjectname1 ='"+subjectname1+"' and s.subjectName='"+subjectname1+"'";
        Statement st; 
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            LecturerGet lecturerGet;
            while(rs.next()){
                lecturerGet = new LecturerGet (rs.getString("duration"), rs.getString("lecturename"),
                        rs.getString("yearsem"),rs.getString("sgroupid"),rs.getString("startingtime"),rs.getString("subjectname1"));
                lecturerGetList.add(lecturerGet);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return lecturerGetList;
    }
     public void ShowSelectSubject(){
         ObservableList<LecturerGet> list = getSelectSubjectList();
         
         colDuration.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("duration"));
         colLecture.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("lecturename"));
         colGroup.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("yearsem"));
         colSub.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("sgroupid"));
         colSession.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("startingtime"));
         colSubject.setCellValueFactory(new PropertyValueFactory<LecturerGet, String>("subjectname1"));
         
         
         tvDuration.setItems(list);
         
    }
     

    @FXML
    private void comboSelectLec(ActionEvent event) {
        
        System.out.println("test test");
        ShowDuration();
        
        
    }

    @FXML
    private void comboSelectGroup(ActionEvent event) {
        ShowSelectGroup();
    }

    @FXML
    private void comboSelectSub(ActionEvent event) {
        ShowSelectSubGroup();
    }

//    private void comboSelectSession(ActionEvent event) {
//        
//        
//    }

    @FXML
    private void comboSelectSubject(ActionEvent event) {
        ShowSelectSubject();
    }

    @FXML
    private void btnCheckEvent(ActionEvent event) {
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
