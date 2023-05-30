package main;

import java.util.Random;
import main.warrior;
import main.potions;
import main.shield;

public class vampireAttack extends Weapons {
    public vampireAttack(double damage, double accuracy) {
        super(damage, accuracy);
    }
    warrior enemy = new warrior("enemy", 100);
    berserkPotion berserk = new berserkPotion("Berserk", 1);
    malhitePotion malhite = new malhitePotion("Malhite", 1);
    shield shield = new shield("Shield", 1);
    claw claw = new claw("Claw", 1);
    bite bite = new bite("Bite", 1);
    soulShypon soulShypon = new soulShypon("Soul Syphon", 1);

    public void vampireAttacks() {
        String[] attacks = {"Claw", "Bite", "Soul Syphon"};
        Random rand = new Random();
        int attackIndex = rand.nextInt(attacks.length);
        String selectedAttack = attacks[attackIndex];
        switch (selectedAttack) {
            case "Claw" -> {
                claw.clawAttack();
            }
            case "Bite" -> {
                bite.biteAttack();
            }
            case "Soul Syphon" -> {
                soulShypon.soulAttack();
            }
        }
    }
}

