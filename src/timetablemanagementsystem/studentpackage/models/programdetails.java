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
public class programdetails {
    private String id;
     private String p_name;
    private String pf_name;

    public programdetails(String id, String p_name, String pf_name) {
        this.id = id;
        this.p_name = p_name;
        this.pf_name = pf_name;
    }

    public String getId() {
        return id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getPf_name() {
        return pf_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public void setPf_name(String pf_name) {
        this.pf_name = pf_name;
    }

   
    
    
}
