package timetablemanagementsystemfx.models;

public class Building {
    private String buildingId;
    private String buildingName;

    public Building(String buildingId, String buildingName) {
        this.buildingId = buildingId;
        this.buildingName = buildingName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    @Override
    public String toString() {
        return this.getBuildingName();
    }    
}
