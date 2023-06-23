package main;


public class Warrior extends Characters {
    public Warrior(String name, double health) {
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

