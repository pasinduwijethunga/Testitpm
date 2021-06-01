package timetablemanagementsystemfx.models;

public class LecturerModel {
    
    String lecturerId;
    String name;
    String faculty;
    String bulding;
    String center;
    String department;
    String category;
    String level;
    String rank;

    public LecturerModel() {
    }

    public LecturerModel(String lecturerId, String name, String faculty, String bulding, String center, String department, String category, String level, String rank) {
        
        this.lecturerId = lecturerId;
        this.name = name;
        this.faculty = faculty;
        this.bulding = bulding;
        this.center = center;
        this.department = department;
        this.category = category;
        this.level = level;
        this.rank = rank;
    
    }

    public String getLecturerId() {
       
        return lecturerId;
    
    }

    public void setLecturerId(String lecturerId) {
      
        this.lecturerId = lecturerId;
    
    }

    public String getName() {
    
        return name;
    
    }

    public void setName(String name) {
  
        this.name = name;
    
    }

    public String getFaculty() {
    
        return faculty;
    
    }

    public void setFaculty(String faculty) {
    
        this.faculty = faculty;
    
    }

    public String getBulding() {
    
        return bulding;
    
    }

    public void setBulding(String bulding) {
    
        this.bulding = bulding;
   
    }

    public String getCenter() {
    
        return center;
    
    }

    public void setCenter(String center) {
    
        this.center = center;
   
    }

    public String getDepartment() {
    
        return department;
    
    }

    public void setDepartment(String department) {
    
        this.department = department;
   
    }

    public String getCategory() {
    
        return category;
    
    }

    public void setCategory(String category) {
     
        this.category = category;
    
    }

    public String getLevel() {
     
        return level;
    
    }

    public void setLevel(String level) {
    
        this.level = level;
    
    }

    public String getRank() {
    
        return rank;
    
    }

    public void setRank(String rank) {
   
        this.rank = rank;
    
    }

    @Override
    public String toString() {
        return this.getLecturerId();
    }
    
    
}
