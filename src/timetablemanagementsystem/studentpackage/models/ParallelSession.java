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
public class ParallelSession {
    
    private String id;
    private String subjectname1;
    private String subjectname2;
    private String lecturename;
    private String yearsem;
    private String groupid;
    private String sgroupid;
    private String startingtime;
    private String endtime;
    private String day;
    private String duration;

    public ParallelSession(String id, String subjectname1, String subjectname2, String lecturename, String yearsem, String groupid, String sgroupid, String startingtime, String endtime, String day, String duration) {
        this.id = id;
        this.subjectname1 = subjectname1;
        this.subjectname2 = subjectname2;
        this.lecturename = lecturename;
        this.yearsem = yearsem;
        this.groupid = groupid;
        this.sgroupid = sgroupid;
        this.startingtime = startingtime;
        this.endtime = endtime;
        this.day = day;
        this.duration = duration;
    }

    public String getSubjectname1() {
        return subjectname1;
    }

    public void setSubjectname1(String subjectname1) {
        this.subjectname1 = subjectname1;
    }

    public String getSubjectname2() {
        return subjectname2;
    }

    public void setSubjectname2(String subjectname2) {
        this.subjectname2 = subjectname2;
    }

    

    public ParallelSession() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    public String getYearsem() {
        return yearsem;
    }

    public void setYearsem(String yearsem) {
        this.yearsem = yearsem;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getSgroupid() {
        return sgroupid;
    }

    public void setSgroupid(String sgroupid) {
        this.sgroupid = sgroupid;
    }

    public String getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(String startingtime) {
        this.startingtime = startingtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
