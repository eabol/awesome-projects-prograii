package main;
import java.util.Random;
public class Vampire extends Characters{

    public Vampire(String name, int health, int attack, int defense, int accuracy) {
        super(name, health, attack, defense,accuracy);
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
        String[] attacks = {"Attack 1", "Attack 2", "Attack 3"};
        Random rand = new Random();
        int attackIndex = rand.nextInt(attacks.length);
        String selectedAttack = attacks[attackIndex];
        switch (selectedAttack) {
            case "Attack 1" -> {
                int randomNum = rand.nextInt(100) + 1;
                if (randomNum <= 91) {
                    System.out.println(this.name + " missed!");
                    break;
                } else {
                    int damage = this.attack - enemy.defense;
                    enemy.health -= damage;
                    System.out.println(this.name + " attacked " + enemy.name + " for " + damage + " damage!");
                }
                }
            case "Attack 2" -> {
                int randomNum = rand.nextInt(100) + 1;
                if (randomNum < 61) {
                    System.out.println(this.name + " missed!");
                    break;
                } else {
                    int damage2 = this.attack - enemy.defense;
                    enemy.health -= damage2;
                    System.out.println(this.name + " attacked " + enemy.name + " for " + damage2 + " damage!");
                }
            }
            case "Attack 3" -> {
                int randomNum = rand.nextInt(100) + 1;
                if (randomNum <41) {
                    System.out.println(this.name + " missed!");
                    break;
                } else {
                    int damage3 = this.attack - enemy.defense;
                    enemy.health -= damage3;
                    System.out.println(this.name + " attacked " + enemy.name + " for " + damage3 + " damage!");
                }
            }
            }
        }

    }

