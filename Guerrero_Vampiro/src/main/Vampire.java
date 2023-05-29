package main;
import java.util.Random;
public class Vampire extends Characters{

    public Vampire(String name, double health, double attack,double accuracy) {
        super(name, health, attack,accuracy);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(double health) {
        this.health = health;
    }
    public void setAttack(double attack) {
        this.attack = attack;
    }
    public double getHealth() {
        return this.health;
    }
    public double getAttack() {
        return this.attack;
    }
    public String getName() {
        return this.name;
    }
    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
    public double getAccuracy() {
        return this.accuracy;
    }

    }

