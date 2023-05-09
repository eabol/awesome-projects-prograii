package main;


public class warrior extends Characters {
    public warrior(String name, double health, double attack, double defense , double accuracy) {
        super(name, health, attack, defense, accuracy);
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
    public void setDefense(double defense) {
        this.defense = defense;
    }
    public double getHealth() {
        return this.health;
    }
    public double getAttack() {
        return this.attack;
    }
    public double getDefense() {
        return this.defense;
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
    public void attack(Characters enemy) {
        double damage = this.attack - enemy.defense;
        enemy.health -= damage;
        System.out.println(this.name + " attacked " + enemy.name + " for " + damage + " damage!");
    }

}

