package timetablemanagementsystemfx.models;

public class SessionModel {
    
    int id;
    String lecturer;
    String subjectname;
    String subjectcode;
    String sgroupid;
    String tag;
    String duration;
    String studentcount;

    public SessionModel() {
    }

    public SessionModel(int id, String lecturer, String subjectname, String subjectcode, String sgroupid, String tag, String duration, String studentcount) {
        this.id = id;
        this.lecturer = lecturer;
        this.subjectname = subjectname;
        this.subjectcode = subjectcode;
        this.sgroupid = sgroupid;
        this.tag = tag;
        this.duration = duration;
        this.studentcount = studentcount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public String getSubjectcode() {
        return subjectcode;
    }

    public void setSubjectcode(String subjectcode) {
        this.subjectcode = subjectcode;
    }

    public String getSgroupid() {
        return sgroupid;
    }

    public void setSgroupid(String sgroupid) {
        this.sgroupid = sgroupid;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getStudentcount() {
        return studentcount;
    }

    public void setStudentcount(String studentcount) {
        this.studentcount = studentcount;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
}
