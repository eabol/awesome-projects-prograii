package main;
import main.shield;


public class warrior extends Characters {
    public warrior(String name, double health, double attack, double accuracy) {
        super(name, health, attack, accuracy);
    }
    shield shield = new shield("shield", 1);
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


    public void setShieldActive(boolean b) {
        shield.activateShield();
    }
    public void setShieldInactive(boolean b) {
        shield.deactivateShield();
    }
    public boolean getShieldActive() {
        return shield.activateShield();
    }
    public boolean getShieldInactive() {
        return shield.deactivateShield();
    }
}

