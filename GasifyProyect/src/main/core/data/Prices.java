package main.core.data;

public class Prices {

    private int year;
    private String period;
    private float value;

    public Prices(int year, String period, int value) {
        this.year = year;
        this.period = period;
        this.value = value;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public float getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
