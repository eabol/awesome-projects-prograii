package main;
import main.shield;


public class warrior extends Characters {
    public warrior(String name, double health) {
        super(name, health);
    }
    shield shield = new shield("shield", 1);
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

