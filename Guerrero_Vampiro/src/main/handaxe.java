package main;
import main.potions;
public class handaxe extends Weapons {
    public handaxe(double damage, double accuracy) {
        super(damage, accuracy);
    }
    public void handaxeAttack(double damage, double accuracy) {

        boolean berserkActive = true;
        potions berserk = new potions("Berserk", 1);
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
