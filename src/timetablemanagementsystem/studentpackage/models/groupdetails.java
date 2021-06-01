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
public class groupdetails {
    private String id;
    private String year_sem;
    private String programe;
    private String  gnum;
    private String sgnum;
    private String group_id;

    public void setId(String id) {
        this.id = id;
    }

    public void setYear_sem(String year_sem) {
        this.year_sem = year_sem;
    }

    public void setPrograme(String programe) {
        this.programe = programe;
    }

    public void setGnum(String gnum) {
        this.gnum = gnum;
    }

    public void setSgnum(String sgnum) {
        this.sgnum = sgnum;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public void setSgroup_id(String sgroup_id) {
        this.sgroup_id = sgroup_id;
    }

    public String getId() {
        return id;
    }

    public groupdetails(String id, String year_sem, String programe, String gnum, String sgnum, String group_id, String sgroup_id) {
        this.id = id;
        this.year_sem = year_sem;
        this.programe = programe;
        this.gnum = gnum;
        this.sgnum = sgnum;
        this.group_id = group_id;
        this.sgroup_id = sgroup_id;
    }
    private String  sgroup_id;

    public String getYear_sem() {
        return year_sem;
    }

    public String getPrograme() {
        return programe;
    }

    public String getGnum() {
        return gnum;
    }

    public String getSgnum() {
        return sgnum;
    }

    public String getGroup_id() {
        return group_id;
    }

    public String getSgroup_id() {
        return sgroup_id;
    }

    
        
    
}
