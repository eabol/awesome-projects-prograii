package main;
import main.Flail;
import main.sword;
import main.handaxe;
import main.potions;
import main.warrior;
import main.shield;

import java.util.ArrayList;

public class WarriorActions extends warrior{

    ArrayList<Equipment> EquipmentArrayList = new ArrayList<>();
    public WarriorActions(){
        super("0", 0, 0, 0);
    }

    Flail attackFlail = new Flail(30, 12);
    sword attackSword = new sword(7, 50);
    handaxe attackHandaxe = new handaxe(15, 25);
    potions berserk = new potions("Berserk", 1);
    warrior Warrior = new warrior("Warrior", 100, 100, 100);
    shield shield = new shield("Shield", 1);



    public void attackFlail(){
        attackFlail.setDamage(30);
        attackFlail.setAccuracy(12);
        attackFlail.FlailAttack(30, 12);
    }
    public void attackSword(){
        attackSword.setDamage(7);
        attackSword.setAccuracy(50);
        attackSword.swordAttack(7, 50);
    }
    public void attackHandaxe(){
        attackHandaxe.setDamage(15);
        attackHandaxe.setAccuracy(25);
        attackHandaxe.handaxeAttack(15, 25);
    }

    public void checkEquipment(ArrayList<Equipment> EquipmentArrayList){

        System.out.println(EquipmentArrayList);

    }
    public void useEquipment(){
        System.out.println("Which equipment do you want to use?");
        System.out.println("1. Berserker Potion");
        System.out.println("2. Last Breath");
        System.out.println("3. Rock Solid");
        System.out.println("4. Seagull Eye");
        System.out.println("5. Twitter Essence");
        System.out.println("6. Exit");

        switch (1){
            case 1:
                System.out.println("You used Berserker Potion!");
                berserk.berserkPotion(Warrior);
                break;
            case 2:
                System.out.println("You used Last Breath!");
                berserk.lastBreath(Warrior);
                break;
            case 3:
                System.out.println("You used Rock Solid!");
                berserk.rockSolid(Warrior);
                break;
            case 4:
                System.out.println("You used Seagull Eye!");
                berserk.seagullEye(Warrior);
                break;
            case 5:
                System.out.println("You used Twitter Essence!");
                berserk.twitterEssence(Warrior);
                break;
            case 6:
                System.out.println("You exited the menu!");
                break;
        }
    }

    public void useShield(){
        System.out.println("You used Shield!");
        shield.activateShield();
    }

}

