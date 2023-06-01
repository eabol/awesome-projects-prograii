package main;

import java.util.Random;

public class SoulShypon extends Weapons {

    GeneralManager generalManager = new GeneralManager();
    


    Warrior enemy = new Warrior("enemy",100);


    Vampire vampire = new Vampire("Vampire", 100);

    public SoulShypon(String name, int damage) {
        super(damage, 0);
    }


    public void soulAttack() {
        Random rand = new Random();
        setDamage(20);
        int randomNum = rand.nextInt(100) + 1;
        if (randomNum <= 40) {
            System.out.println("The vampire missed!");
        } else {
            if (enemy.getHealth() <= 0) {
                System.out.println("The vampire has killed you");
                System.out.println("You have lost the game");
                System.exit(0);
            } else {

                    enemy.setHealth(enemy.getHealth() - this.getDamage());
                    vampire.setHealth(vampire.getHealth() + this.getDamage());
                    System.out.println("You feel the vampire's soul syphon drain your life! He dealt " + this.getDamage() + " damage!");
                    if (enemy.getHealth() <= 0) {
                        System.out.println("The vampire has killed you");
                        System.out.println("You have lost the game");
                        System.exit(0);
                    } else {
                        System.out.println("You have " + enemy.getHealth() + " health left");
                    }
                }
            }
        }
    }

