package core;

public class Time {
    private int hours;
    private int minutes;
    private int tick;

    public Time (int hours, int minutes, int tick) {
        setTick(tick);
        setTime(hours, minutes);
    }

    private void setTime(int hours, int minutes) {
        if (isValidTime(hours, minutes)) {
            this.hours = hours;
            this.minutes = minutes;
        } else throw new IllegalArgumentException("Invalid value for Time");
    }
    public void setTick(int tick) {
        if (tick >= 0) {
            this.tick = tick;
        } else {
            throw new IllegalArgumentException("Invalid tick value specified.");
        }
    }


    private boolean isValidTime(int hours, int minutes) {
        return (hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60);
    }

    public void advanceTime () {
        minutes += tick;
        while (minutes >= 60) {
            minutes -= 60;
            hours = (hours + 1) % 24;
        }
    }

    public boolean isNight(){
        return (hours > 20 || hours < 6);
    }
    public String getTime() {
        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);
        return formattedHours + ":" + formattedMinutes;
    }
}
