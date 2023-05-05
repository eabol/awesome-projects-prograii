package main;

public abstract class Characters {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int accuracy;

    public Characters(String name, int health, int attack, int defense, int accuracy) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.accuracy = accuracy;
    }


}
