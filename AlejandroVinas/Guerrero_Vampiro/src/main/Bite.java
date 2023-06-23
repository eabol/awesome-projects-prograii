package main;


import java.util.Random;

public class Bite extends Weapons {

    GeneralManager generalManager = new GeneralManager();

    Warrior enemy = new Warrior("enemy", 100);



    public Bite(String name, int damage) {
        super(damage, 0);
    }

    public void biteAttack() {
        Random rand = new Random();
        setDamage(15);
        int randomNum = rand.nextInt(100);
        if (randomNum <= 60) {
            System.out.println("The vampire missed!");
        } else {
             {
                    enemy.setHealth(enemy.getHealth() - this.getDamage());
                    System.out.println("The vampire feast on your flesh dealing " + this.getDamage() + " damage!");
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

