package main;

public abstract class Characters {
    protected String name;
    protected double health;
    protected double attack;
    protected double accuracy;

    public Characters(String name, double health, double attack, double accuracy) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.accuracy = accuracy;
    }


}
