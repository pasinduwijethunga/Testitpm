package timetablemanagementsystemfx.models;

public class Department {
    private String departmentId;
    private String departmentName;
    private String facultyId;

    public Department(String departmentId, String departmentName, String facultyId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.facultyId = facultyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public String toString() {
        return this.getDepartmentName();
    }
    
    
}
