package main;


import java.util.Random;

public class Claw extends Weapons {

    GeneralManager generalManager = new GeneralManager();


    Warrior enemy = new Warrior("enemy", 100);

    public Claw(String name, int damage) {
        super(damage, 0);
    }


    public void clawAttack() {
        Random rand = new Random();
        setDamage(10);
        int randomNum = rand.nextInt(100);
        if (randomNum <= 90) {
            System.out.println("The vampire missed!");
        } else {
            if (enemy.getHealth() <= 0) {
                System.out.println("The vampire has killed you");
                System.out.println("You have lost the game");
                System.exit(0);
            } else {

                    enemy.setHealth(enemy.getHealth() - this.getDamage());
                    System.out.println("the vampire sinks his claws into you dealing " + this.getDamage() + " damage!");
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



