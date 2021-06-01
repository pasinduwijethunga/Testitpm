/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystemfx.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

/**
 *
 * @author Programming
 */
public class dbConnection {

    public static final Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection dbConnection;
        //SQL Database connection params
        String dbHost = "localhost";
        String dbPort = "3306";
        String dbUser = "root";
        String dbPassword = "";
        String dbName = "timetable";
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useLegacyDatetimeCode=false&amp&serverTimezone=" + TimeZone.getDefault().getID();

//        Class.forName("com.mysql.cj.jdbc.Driver");

        //Connecting to Database
//        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPassword);
//        return dbConnection;
        
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable","root","");
            return conn;
        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
}
