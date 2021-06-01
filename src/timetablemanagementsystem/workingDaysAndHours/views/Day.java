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
public class Day {
    private int id;
    private int No_workigdays;
    private String workingDays;
    private String workinghours;
    private String workingminute;
    private String timeSlot;

    public Day(int id, int No_workigdays, String workingDays, String workinghours, String workingminute, String timeSlot) {
        this.id = id;
        this.No_workigdays = No_workigdays;
        this.workingDays = workingDays;
        this.workinghours = workinghours;
        this.workingminute = workingminute;
        this.timeSlot = timeSlot;
    }

    public int getId() {
        return id;
    }

    public int getNo_workigdays() {
        return No_workigdays;
    }

    public String getWorkingDays() {
        return workingDays;
    }

    public String getWorkinghours() {
        return workinghours;
    }

    public String getWorkingminute() {
        return workingminute;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    
    
    

}  