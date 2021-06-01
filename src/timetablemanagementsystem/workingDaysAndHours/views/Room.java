/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.workingDaysAndHours.views;

/**
 *
 * @author Isuru
 */
public class Room {
    
    private int tfId;
    private String tfRoom;
    private String tfDay;
    private String tfStartTime;
    private String tfEndTime;

    public Room(int tfId, String tfRoom, String tfDay, String tfStartTime, String tfEndTime) {
        this.tfId = tfId;
        this.tfRoom = tfRoom;
        this.tfDay = tfDay;
        this.tfStartTime = tfStartTime;
        this.tfEndTime = tfEndTime;
    }

    public int getTfId() {
        return tfId;
    }

    public String getTfRoom() {
        return tfRoom;
    }

    public String getTfDay() {
        return tfDay;
    }

    public String getTfStartTime() {
        return tfStartTime;
    }

    public String getTfEndTime() {
        return tfEndTime;
    }

    
}
