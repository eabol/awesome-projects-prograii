package main;

import java.util.Random;

public class soulShypon  extends vampireAttack{

    private static final double precission = 0;

    public soulShypon(String name, int damage) {
        super(damage,precission);
    }

    public void soulAttack(){
        Random rand = new Random();
        setDamage(20);
        int randomNum = rand.nextInt(100) + 1;
        if (randomNum <=40){
            System.out.println("The vampire missed!");
        }  else {
            if(berserk.berserkActive == true && randomNum < 89) {
                double damage = this.getDamage()/2;
                enemy.setHealth(enemy.getHealth() - damage);
            } else if (malhite.rockActive==true) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            }else if (shield.isShieldActive) {
                double damage = this.getDamage() / 4;
                enemy.setHealth(enemy.getHealth() - damage);
            }
        }
    }
}
