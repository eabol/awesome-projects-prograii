package main;
import main.Flail;
import main.sword;
import main.handaxe;
import main.potions;
import main.warrior;
import main.shield;
import java.util.Scanner;

import java.util.ArrayList;

public class WarriorActions extends warrior{

    ArrayList<Equipment> EquipmentArrayList = new ArrayList<>();
    public WarriorActions(){
        super("0", 0);
    }

    Flail attackFlail = new Flail(30, 12);
    sword attackSword = new sword(7, 50);
    handaxe attackHandaxe = new handaxe(15, 25);
    berserkPotion berserk = new berserkPotion("Berserk", 1);
    lastBreathPotion lastBreath = new lastBreathPotion("Last Breath", 1);
    malhitePotion malhite = new malhitePotion("Rock Solid", 1);
    twitterPotion twitter = new twitterPotion("Twitter", 1);
    seagullPotion seagull = new seagullPotion("Seagull", 1);

    warrior Warrior = new warrior("Warrior", 100);
    shield shield = new shield("Shield", 1);

    public void iniciate (){
        EquipmentArrayList.add(berserk);
        EquipmentArrayList.add(lastBreath);
        EquipmentArrayList.add(malhite);
        EquipmentArrayList.add(twitter);
        EquipmentArrayList.add(seagull);
    }




    public void attackFlail(){
        attackFlail.setDamage(30);
        attackFlail.setAccuracy(12);
        attackFlail.FlailAttack(30, 12);
        attackFlail.hit();
    }
    public void attackSword(){
        attackSword.setDamage(7);
        attackSword.setAccuracy(50);
        attackSword.swordAttack(7, 50);
        attackSword.hit();
    }
    public void attackHandaxe(){
        attackHandaxe.setDamage(15);
        attackHandaxe.setAccuracy(25);
        attackHandaxe.handaxeAttack(15, 25);
        attackHandaxe.hit();
    }

    public void checkEquipment(ArrayList<Equipment> EquipmentArrayList){

        for (int i = 0; i < EquipmentArrayList.size(); i++) {
            System.out.println(EquipmentArrayList.get(i));
        }
    }


    public void useShield(shield shield){
        System.out.println("You used Shield!");
        shield.activateShield();
    }

}

