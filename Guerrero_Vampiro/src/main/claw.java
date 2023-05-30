package main;


import java.util.Random;

public class claw extends vampireAttack{

    private static final double precission = 0;

    public claw(String name, int damage) {
        super(damage, precission);
    }

    public void clawAttack(){
        Random rand = new Random();
        setDamage(10);
        int randomNum = rand.nextInt(100);
        if (randomNum <=90) {
            System.out.println("The vampire missed!");
        } else {

            if(berserk.berserkActive == true && randomNum < 89) {
                double damage = this.getDamage()/2;
                enemy.setHealth(enemy.getHealth() - damage);
            } else if (malhite.rockActive==true) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            } else if (shield.isShieldActive) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            }
        }
    }
}
