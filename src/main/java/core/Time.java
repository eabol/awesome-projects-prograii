package core;

public class Time {
    private int hours;
    private int minutes;
    private int tick;
    private int timeCooldown = 0;
    private final int timeCooldownMax = 60;

    public Time(int hours, int minutes, int tick) {
        setTick(tick);
        setTime(hours, minutes);
    }

    private void setTime(int hours, int minutes) {
        if (isValidTime(hours, minutes)) {
            this.hours = hours;
            this.minutes = minutes;
        } else
            throw new IllegalArgumentException("Invalid value for Time");
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

    public void advanceTime() {
        if (timeCooldown < timeCooldownMax) {
            timeCooldown++;
        } else {
            timeCooldown = 0;
            minutes += tick;
            while (minutes >= 60) {
                minutes -= 60;
                setMinutes(minutes);
                hours = (hours + 1) % 24;
                setHours(hours);
            }
        }
    }

    public String getMomentOfDay() {
        String dayMoment = "day";

        if (hours > 21 || hours < 6) {
            dayMoment = "isNight";
        }

        if (hours >= 6 && hours <= 12) {
            dayMoment = "isMorning";
        }

        if (hours >= 18 && hours <= 21) {
            dayMoment = "isSunset";
        }
        return dayMoment;
    }

    public boolean isNight() {
        if (hours > 21 || hours < 6) {
            return true;
        }
        return false;
    }

    public boolean isMorning() {
        if (hours >= 6 && hours <= 12) {
            return true;
        }
        return false;
    }

    public boolean isSunset() {
        if (hours >= 18 && hours <= 21) {
            return true;
        }
        return false;
    }

    public String getTime() {
        String formattedHours = String.format("%02d", hours);
        String formattedMinutes = String.format("%02d", minutes);
        return formattedHours + ":" + formattedMinutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    void setHours(int hours) {
        this.hours = hours;
    }

    private void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return tick;
    }
}
