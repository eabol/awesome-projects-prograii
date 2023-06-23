package main;

import java.util.Random;

public class VampireAttack extends Weapons {
    public VampireAttack(double damage, double accuracy) {
        super(damage, accuracy);
    }
    main.Claw Claw = new Claw("Claw", 1);
    Bite bite = new Bite("Bite", 1);
    SoulShypon soulShypon = new SoulShypon("Soul Syphon", 1);

    public void vampireAttacks() {
        String[] attacks = {"Claw", "Bite", "Soul Syphon"};
        Random rand = new Random();
        int attackIndex = rand.nextInt(attacks.length);
        String selectedAttack = attacks[attackIndex];
        switch (selectedAttack) {
            case "Claw" -> {
                Claw.clawAttack();
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

