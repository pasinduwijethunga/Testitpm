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
public class ConsecutiveSession {
    
    private String id;
    private String subjectname;
    private String subjectid;
    private String lecturename;
    private String lecturetime;
    private String tutorialtime;
    private String yearsem;
    private String groupid;
    private String sgroupid;

    public ConsecutiveSession(String id, String subjectname, String subjectid, String lecturename, String lecturetime, String tutorialtime, String yearsem, String groupid, String sgroupid) {
        this.id = id;
        this.subjectname = subjectname;
        this.subjectid = subjectid;
        this.lecturename = lecturename;
        this.lecturetime = lecturetime;
        this.tutorialtime = tutorialtime;
        this.yearsem = yearsem;
        this.groupid = groupid;
        this.sgroupid = sgroupid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ConsecutiveSession() {
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(String subjectid) {
        this.subjectid = subjectid;
    }

    public String getLecturename() {
        return lecturename;
    }

    public void setLecturename(String lecturename) {
        this.lecturename = lecturename;
    }

    public String getLecturetime() {
        return lecturetime;
    }

    public void setLecturetime(String lecturetime) {
        this.lecturetime = lecturetime;
    }

    public String getTutorialtime() {
        return tutorialtime;
    }

    public void setTutorialtime(String tutorialtime) {
        this.tutorialtime = tutorialtime;
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
    
    

    
}
