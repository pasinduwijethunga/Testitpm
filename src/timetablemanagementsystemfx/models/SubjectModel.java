package timetablemanagementsystemfx.models;

public class SubjectModel {
    
    String subjectCode;
    String subjectName;
    String offeredYear;
    String offeredSemester;
    int noOfLecHours;
    int noOfTutHours;
    int noOfLabHours;
    int noOfEveHours;

    public SubjectModel() {
    }

    public SubjectModel(String subjectCode, String subjectName, String offeredYear, String offeredSemester, int noOfLecHours, int noOfTutHours, int noOfLabHours, int noOfEveHours) {
        
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.offeredYear = offeredYear;
        this.offeredSemester = offeredSemester;
        this.noOfLecHours = noOfLecHours;
        this.noOfTutHours = noOfTutHours;
        this.noOfLabHours = noOfLabHours;
        this.noOfEveHours = noOfEveHours;
    
    }

    public String getSubjectCode() {
        
        return subjectCode;
        
    }

    public void setSubjectCode(String subjectCode) {
        
        this.subjectCode = subjectCode;
        
    }

    public String getSubjectName() {
        
        return subjectName;
        
    }

    public void setSubjectName(String subjectName) {
        
        this.subjectName = subjectName;
        
    }
    
    public String getOfferedYear() {
        
        return offeredYear;
        
    }

    public void setOfferedYear(String offeredYear) {
        
        this.offeredYear = offeredYear;
        
    }

    public String getOfferedSemester() {
        
        return offeredSemester;
        
    }

    public void setOfferedSemester(String offeredSemester) {
        
        this.offeredSemester = offeredSemester;
        
    }

    public int getNoOfLecHours() {
        
        return noOfLecHours;
        
    }

    public void setNoOfLecHours(int noOfLecHours) {
        
        this.noOfLecHours = noOfLecHours;
        
    }

    public int getNoOfTutHours() {
        
        return noOfTutHours;
        
    }

    public void setNoOfTutHours(int noOfTutHours) {
        
        this.noOfTutHours = noOfTutHours;
        
    }

    public int getNoOfLabHours() {
        
        return noOfLabHours;
        
    }

    public void setNoOfLabHours(int noOfLabHours) {
        
        this.noOfLabHours = noOfLabHours;
        
    }

    public int getNoOfEveHours() {
        
        return noOfEveHours;
        
    }

    public void setNoOfEveHours(int noOfEveHours) {
        
        this.noOfEveHours = noOfEveHours;
        
    }

    @Override
    public String toString() {
        return this.getSubjectCode();
    }
    
    
}
