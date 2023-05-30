package main;

import java.util.Random;

public class Flail extends Weapons {
    public Flail(double damage, double accuracy) {
        super(damage, accuracy);
    }

    Vampire Vampire = new Vampire("Dracula", 100);
    public void FlailAttack(double damage, double accuracy) {
        berserkPotion berserk = new berserkPotion("Berserk", 1);
        twitterPotion twitter = new twitterPotion("Twitter", 1);
        seagullPotion seagull = new seagullPotion("Seagull", 1);
        if (berserk.berserkActive) {
            damage = damage * 1.5;
            accuracy = accuracy * 1.5;
        }else{
            damage = damage;
            accuracy = accuracy;
        }
        if (twitter.twitterActive) {
            accuracy = accuracy * 1.5;
        }else {
            damage = damage;
            accuracy = accuracy;
        }
        if (seagull.eyeActive) {
            damage = damage + 8;
        }else {
            damage = damage;
            accuracy = accuracy;
        }

    }
    public void hit (){
        FlailAttack(getDamage(), getAccuracy());
        Random random1 = new Random();
        int Random2 = random1.nextInt(1, 100);
        int accuracy2 = (int)getAccuracy();
        if (Random2 <= accuracy2) {
            Vampire.setHealth(Vampire.getHealth() -getDamage());
            System.out.println("You have attacked the vampire with your handaxe. The vampire has received " + getDamage() + " damage");
            System.out.println("The vampire's health is now " + Vampire.getHealth());
        }
        else {
            System.out.println("You have missed your attack");
        }
    }


}
