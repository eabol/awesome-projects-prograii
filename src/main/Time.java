package src.main;

public class Time {
    public int hours;
    public int minutes;
    public int tick;

    public Time(int hours, int minutes, int tick) {
        this.hours = hours;
        this.minutes = minutes;
        this.tick = tick;
    }

    private void setTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    private void getTime() {
        System.out.println("Time: " + this.hours + ":" + this.minutes);
    }

    private void verifyTime(int hours, int minutes) {
        if (hours > 23 || hours < 0) {
            System.out.println("Invalid hour");
        } else if (minutes > 59 || minutes < 0) {
            System.out.println("Invalid minute");
        } else {
            setTime(hours, minutes);
        }
    }

    private void setTick(int tick) {
        this.tick = tick;
    }

    public void advanceTime(int hours, int minutes) {
        verifyTime(hours, minutes);
        getTime();
    }

    public boolean isNight() {
        return false;
    }
}
