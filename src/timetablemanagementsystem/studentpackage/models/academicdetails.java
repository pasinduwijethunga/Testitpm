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
public class academicdetails {
   private String id;
   private String year;
   private String semester;
   private String type;

    public academicdetails(String id, String year, String semester, String type) {
        this.id = id;
        this.year = year;
        this.semester = semester;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setType(String type) {
        this.type = type;
    }
  
}
