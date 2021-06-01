/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystemfx.utils;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Programming
 */
public class DynamicViewsLoader {

    public DynamicViewsLoader() {
    }
    
    public static void loadChild(BorderPane borderPane, String resource) {
        Parent childNode;
        try {
            childNode = FXMLLoader.load(new DynamicViewsLoader().getClass().getResource("/timetablemanagementsystemfx/views/" + resource));
            borderPane.setCenter(childNode);
        } catch (IOException ex) {
            Logger.getLogger(DynamicViewsLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
