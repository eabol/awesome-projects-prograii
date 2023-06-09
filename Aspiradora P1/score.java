public class Score {
    private int totalSteps;
    private int totalDirt;
    private int dirtynessLevel;
    private int batteryLevel;

    public Score() {
        totalSteps = 0;
        totalDirt = 0;
        dirtynessLevel = 0;
        batteryLevel = 100;
    }

    public int getSteps() {
        return totalSteps;
    }

    public int getDirty() {
        return totalDirt;
    }

    public int getDirtyLevel() {
        return dirtynessLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
}
