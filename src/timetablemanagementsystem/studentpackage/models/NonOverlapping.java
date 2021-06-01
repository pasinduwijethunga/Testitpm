/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetablemanagementsystem.studentpackage.models;

/**
 *
 * @author Kavindi Gayaththri
 */
public class NonOverlapping {
    private String id;
    private String subjectname1;
    private String lecturename;
    private String yearsem;
    private String groupid;
    private String sgroupid;
    private String startingtime;
    private String endtime;
    private String day;
    private String duration;

    public NonOverlapping(String id, String subjectname1, String lecturename, String yearsem, String groupid, String sgroupid, String startingtime, String endtime, String day, String duration) {
        this.id = id;
        this.subjectname1 = subjectname1;
        this.lecturename = lecturename;
        this.yearsem = yearsem;
        this.groupid = groupid;
        this.sgroupid = sgroupid;
        this.startingtime = startingtime;
        this.endtime = endtime;
        this.day = day;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getSubjectname1() {
        return subjectname1;
    }

    public String getLecturename() {
        return lecturename;
    }

    public String getYearsem() {
        return yearsem;
    }

    public String getGroupid() {
        return groupid;
    }

    public String getSgroupid() {
        return sgroupid;
    }

    public String getStartingtime() {
        return startingtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public String getDay() {
        return day;
    }

    public String getDuration() {
        return duration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSubjectname1(String subjectname1) {
        this.subjectname1 = subjectname1;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    public void setYearsem(String yearsem) {
        this.yearsem = yearsem;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public void setSgroupid(String sgroupid) {
        this.sgroupid = sgroupid;
    }

    public void setStartingtime(String startingtime) {
        this.startingtime = startingtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
    
}
