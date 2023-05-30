package main;
import java.util.Random;
public class Vampire extends Characters{

    public Vampire(String name, double health) {
        super(name, health);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public double getHealth() {
        return this.health;
    }
    public String getName() {
        return this.name;
    }

    }

