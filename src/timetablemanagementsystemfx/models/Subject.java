package timetablemanagementsystemfx.models;

public class Subject {

    private String name;
    private String code;

    public Subject() {
    }

    public Subject(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}