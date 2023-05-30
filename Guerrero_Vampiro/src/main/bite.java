package main;


import java.util.Random;

public class bite extends vampireAttack {


    private static final double precission = 0;

    public bite(String name, int damage) {
        super(damage, precission);
    }

    public void biteAttack() {
        Random rand = new Random();
        setDamage(15);
        int randomNum = rand.nextInt(100);
        if (randomNum <= 60) {
            System.out.println("The vampire missed!");
        } else {
            if (berserk.berserkActive == true && randomNum < 89) {
                double damage = this.getDamage() / 2;
                enemy.setHealth(enemy.getHealth() - damage);
            } else if (malhite.rockActive == true) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            } else if (shield.isShieldActive) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            }
        }
    }
}
