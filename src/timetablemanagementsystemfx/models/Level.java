package timetablemanagementsystemfx.models;

public class Level {
    private int level;
    private String levelName;

    public Level(int level, String levelName) {
        this.level = level;
        this.levelName = levelName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public String toString() {
        return this.getLevelName();
    }
    
    
}
