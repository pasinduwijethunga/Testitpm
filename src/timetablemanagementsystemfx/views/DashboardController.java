package timetablemanagementsystemfx.views;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import timetablemanagementsystemfx.utils.DynamicViewsLoader;

public class DashboardController implements Initializable {

    @FXML
    private Label lbl_dateTime;
    @FXML
    private BorderPane mainBorderPain;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initClock();
        DynamicViewsLoader.loadChild(mainBorderPain, "lectures/view.fxml");
    }

    private void initClock() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM YYYY HH:mm:ss");
            lbl_dateTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    @FXML
    private void viewLecturers(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "lectures/view.fxml");
    }

    @FXML
    private void insertLecturers(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "lectures/insert.fxml");
    }

    @FXML
    private void editLecturers(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "lectures/edit.fxml");
    }


    @FXML
    private void viewSubjects(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "subjects/view.fxml");
    }

    @FXML
    private void insertSubjects(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "subjects/insert.fxml");
    }

    @FXML
    private void editSubjects(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "subjects/edit.fxml");
    }

    
    @FXML
    private void viewSessions(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "sessions/view.fxml");
    }
    
    @FXML
    private void insertSessions(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "sessions/insert.fxml");
    }

    @FXML
    private void editSessions(ActionEvent event) {
        DynamicViewsLoader.loadChild(mainBorderPain, "sessions/edit.fxml");
    }
    
    
    @FXML
    private void showHome(MouseEvent event) throws IOException {
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/timetablemanagementsystem/studentpackage/views/Home.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.hide();
        app_stage.setScene(home_page_scene);
        app_stage.show();
    }
}
