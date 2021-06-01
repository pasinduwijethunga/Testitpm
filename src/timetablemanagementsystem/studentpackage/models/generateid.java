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
public class generateid {
    private String id;
    private String year_sem;
    private String programe;
    private String gnum;
    private String sgnum;
    private String groupid;
    private String subgid;

    public generateid(String id, String year_sem, String programe, String gnum, String sgnum, String groupid, String subgid) {
        this.id = id;
        this.year_sem = year_sem;
        this.programe = programe;
        this.gnum = gnum;
        this.sgnum = sgnum;
        this.groupid = groupid;
        this.subgid = subgid;
    }

    public String getId() {
        return id;
    }

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

    public String getGroupid() {
        return groupid;
    }

    public String getSubgid() {
        return subgid;
    }

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

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public void setSubgid(String subgid) {
        this.subgid = subgid;
    }
    
    
                    
    
}
