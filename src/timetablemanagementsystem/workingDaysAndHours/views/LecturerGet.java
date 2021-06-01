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
public class LecturerGet {
    

    

      private String duration;
      private String lecturename;
      private String yearsem;
      private String sgroupid;
      private String startingtime;
      private String subjectname1;

    public LecturerGet(String duration, String lecturename, String yearsem, String sgroupid, String startingtime, String subjectname1) {
        this.duration = duration;
        this.lecturename = lecturename;
        this.yearsem = yearsem;
        this.sgroupid = sgroupid;
        this.startingtime = startingtime;
        this.subjectname1 = subjectname1;
    }

    public String getDuration() {
        return duration;
    }

    public String getLecturename() {
        return lecturename;
    }

    public String getYearsem() {
        return yearsem;
    }

    public String getSgroupid() {
        return sgroupid;
    }

    public String getStartingtime() {
        return startingtime;
    }

    public String getSubjectname1() {
        return subjectname1;
    }
      


   
}
