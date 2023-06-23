package main;

public class Luck implements LuckDirection{

    private final float certainty;

    public Luck() {
        this.certainty = 50;
    }

    public Luck(float certainty) {
        this.certainty = certainty;
    }

    @Override
    public boolean getPositiveLuck() {
        return Math.round(Math.random() * 100) > certainty;
    }

    @Override
    public boolean getNegativeLuck() {
        return Math.round(Math.random() * 100) < certainty;
    }
}
