package main;

import java.util.Random;

public class Sword extends Weapons {
    public Sword(double damage, double accuracy) {
        super(damage, accuracy);
    }

    GeneralManager  generalManager = new GeneralManager();

    Vampire Vampire = new Vampire("Dracula", 100);


    public void swordAttack(double damage, double accuracy) {
        generalManager.iniciate();
            damage = damage;
            accuracy = accuracy;
        }



    public void hit (){
        swordAttack(getDamage(), getAccuracy());
        Random random1 = new Random();
        int Random2 = random1.nextInt(1, 100);
        int accuracy2 = (int)getAccuracy();
        if(Vampire.getHealth()<=0){
            System.out.println("You have killed the vampire");
            System.out.println("You have won the game");
            System.exit(0);
        }
        if (Random2 <= accuracy2) {
            Vampire.setHealth(Vampire.getHealth() -getDamage());
            System.out.println("You have attacked the vampire with your Sword. The vampire has received " + getDamage() + " damage");
            if(Vampire.getHealth()<=0){
                System.out.println("You have killed the vampire");
                System.out.println("You have won the game");
                System.exit(0);
            }else{
                System.out.println("The vampire's health is now " + Vampire.getHealth());

            }


        }
        else {
            System.out.println("You have missed your attack");
        }
    }
}

