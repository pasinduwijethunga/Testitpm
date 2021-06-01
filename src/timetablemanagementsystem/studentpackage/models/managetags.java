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
public class managetags {
    private String id;
    private String tname;
    private String tcode;

    public managetags(String id, String tname, String tcode) {
        this.id = id;
        this.tname = tname;
        this.tcode = tcode;
    }

    public String getId() {
        return id;
    }

    public String getTname() {
        return tname;
    }

    public String getTcode() {
        return tcode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }
    
    
}
