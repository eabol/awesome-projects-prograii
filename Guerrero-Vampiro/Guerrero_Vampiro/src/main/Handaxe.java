package main;

public class Handaxe extends Weapons {
    public Handaxe(double damage, double accuracy) {
        super(damage, accuracy);
        boolean berserkActive = true;
        Potions berserk = new Potions("Berserk", 1);
        if (berserkActive == berserk.activateberserkPotion()) {
            damage = damage * 1.5;
            accuracy = accuracy * 1.5;
        }
        if (berserk.eyeActive) {
            accuracy = accuracy * 1.5;
        }
        if (berserk.twitterActive) {
            damage = damage + 8;
        }

    }}

