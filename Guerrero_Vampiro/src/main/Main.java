package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import main.warrior;
import main.Vampire;
import main.Flail;
import main.sword;
import main.handaxe;
import main.potions;
import main.vampireAttack;
import main.Characters;
import main.Equipment;
import main.Weapons;
import main.shield;
import main.WarriorActions;
public class Main {
public static double size = 0;
boolean playerTurn = true;

public static void main(String[] args) {

    warrior Warrior = new warrior("Warrior", 100, 100, 100);
    Vampire Vampire = new Vampire("Vampire", 100, 100, 100);
    sword Sword = new sword(7, 50);
    handaxe Handaxe = new handaxe(15, 25);
    Flail Flail = new Flail(30, 12);
    potions Potions = new potions("Berserker Potion", 1);
    potions Potions1 = new potions("Last Breath", 1);
    potions Potions2 = new potions("Rock Solid", 1);
    potions Potions3 = new potions("Seagull Eye", 1);
    potions Potions4 = new potions("Twitter Essence", 1);

    ArrayList<Equipment> EquipmentArrayList = new ArrayList<>();
  EquipmentArrayList.addAll(Arrays.asList(
          Potions,
          Potions1,
          Potions2,
          Potions3,
          Potions4
  ));
  System.out.println(EquipmentArrayList);
    EquipmentArrayList.add(Potions);
    EquipmentArrayList.add(Potions1);
    EquipmentArrayList.add(Potions2);
    EquipmentArrayList.add(Potions3);
    EquipmentArrayList.add(Potions4);
    System.out.print(EquipmentArrayList);


}





}
