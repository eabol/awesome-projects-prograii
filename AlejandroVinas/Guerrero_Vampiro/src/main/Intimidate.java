package main;

import java.util.Random;

public class Intimidate extends Weapons{

    Vampire Vampire = new Vampire("Dracula", 100);

    public Intimidate(double damage, double accuracy) {
        super(damage, accuracy);
    }

    public void SpookyAttack(double damage, double accuracy) {
        damage = damage;
        accuracy = accuracy;
    }


    public void hit () {
        SpookyAttack(getDamage(), getAccuracy());
        Random random1 = new Random();
        int Random2 = random1.nextInt(1, 100);
        int accuracy2 = (int) getAccuracy();
        if (Vampire.getHealth() <= 0) {
            System.out.println("You cant intimidate a dead vampire");
            System.out.println("You have won the game");
            System.exit(0);
        }
        if (Random2 <= accuracy2) {
            Vampire.setHealth(Vampire.getHealth() - getDamage());
            System.out.println("You scared the vampire so much that he run away");
            System.out.println("You have won the game");
            System.exit(0);

            } else {
            System.out.println("the vampire is not scared, he is laughing at you");
        }
    }

}
