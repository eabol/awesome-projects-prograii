package main;


public class warrior extends Characters {
    public warrior(String name, int health, int attack, int defense , int accuracy) {
        super(name, health, attack, defense, accuracy);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getHealth() {
        return this.health;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public String getName() {
        return this.name;
    }
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }
    public int getAccuracy() {
        return this.accuracy;
    }
    public void attack(Characters enemy) {
        int damage = this.attack - enemy.defense;
        enemy.health -= damage;
        System.out.println(this.name + " attacked " + enemy.name + " for " + damage + " damage!");
    }

}

