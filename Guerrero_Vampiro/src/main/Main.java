package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
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
        Random random = new Random();
        int min = 1;
        int max = 3;
        vampireAttack vampireAttack = new vampireAttack(5, 90);
        shield Shield = new shield("Shield", 1);
        vampireAttack vampireAttack1 = new vampireAttack(10, 60);
        vampireAttack vampireAttack2 = new vampireAttack(20, 40);

        ArrayList<Equipment> EquipmentArrayList = new ArrayList<>();
        EquipmentArrayList.add(Potions);
        EquipmentArrayList.add(Potions1);
        EquipmentArrayList.add(Potions2);
        EquipmentArrayList.add(Potions3);
        EquipmentArrayList.add(Potions4);


        for (int i = 0; i < EquipmentArrayList.size(); i++) {
            System.out.println(EquipmentArrayList.get(i));
        }


        boolean playerTurn = true;
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            if (playerTurn) {
                System.out.println("It's your turn, choose an action: ");
                int action = scanner.nextInt();
                switch (action) {
                    case 1:
                        System.out.println("You have chosen to attack");
                        System.out.println("Choose a weapon: ");
                        int weapon = scanner.nextInt();
                        switch (weapon) {
                            case 1:
                                System.out.println("Sword");
                                Vampire.setHealth(Vampire.getHealth() - Sword.getDamage());
                                System.out.println("You have attacked the vampire with your sword. The vampire has received " + Sword.getDamage() + " damage");
                                System.out.println("The vampire's health is now " + Vampire.getHealth());
                                break;
                            case 2:
                                System.out.println("Handaxe");
                                Vampire.setHealth(Vampire.getHealth() - Handaxe.getDamage());
                                System.out.println("You have attacked the vampire with your handaxe. The vampire has received " + Handaxe.getDamage() + " damage");
                                System.out.println("The vampire's health is now " + Vampire.getHealth());
                                break;
                            case 3:
                                System.out.println("Flail");
                                Vampire.setHealth(Vampire.getHealth() - Flail.getDamage());
                                System.out.println("You have attacked the vampire with your flail. The vampire has received " + Flail.getDamage() + " damage");
                                System.out.println("The vampire's health is now " + Vampire.getHealth());
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("You have opened your bag");
                        System.out.println("Choose an item to use: ");
                        int potion = scanner.nextInt();
                        switch (potion) {
                            case 1:
                                System.out.println("Berserker Potion");
                                Warrior.setHealth(Warrior.getHealth());
                                Warrior.setAccuracy(Warrior.getAccuracy());
                                Warrior.setAttack(Warrior.getAttack());
                                System.out.println("You have gone Berserker! All your stats have been increased!");
                                break;
                            case 2:
                                System.out.println("Last Breath");
                                Warrior.setHealth(Warrior.getHealth());
                                System.out.println("You have consumed the health potion. Your health is now " + Warrior.getHealth());
                                break;
                            case 3:
                                System.out.println("Rock Solid");
                                Warrior.setHealth(Warrior.getHealth());
                                System.out.println("You have consumed the defense potion. The vampire's attacks will now deal less damage" + Warrior.getHealth());
                                break;
                            case 4:
                                System.out.println("Seagull Eye");
                                Warrior.setAccuracy(Warrior.getAccuracy());
                                System.out.println("You have consumed the accuracy potion. Your accuracy is now " + Warrior.getAccuracy());
                                break;
                            case 5:
                                System.out.println("Twitter Essence");
                                Warrior.setAttack(Warrior.getAttack());
                                System.out.println("You have consumed the attack potion. Your attack is now " + Warrior.getAttack());
                                break;
                            case 6:
                                System.out.println("Shield");
                                Warrior.setHealth(Warrior.getHealth());
                                System.out.println("You have used the shield. The vampire's next attacked will deal less damage." + Warrior.getHealth());
                                break;


                        }
                        break;
                }if (Vampire.getHealth() <= 0) {
                    System.out.println("The vampire has bean defeated! You win!");
                    gameOver = true;
                }
                playerTurn = false;
            } else {
                System.out.println("It's the vampire's turn");
                System.out.println("The vampire attacks you");
                int attack = random.nextInt(max - min + 1) + min;
                switch (attack) {
                    case 1:
                        System.out.println("Claw attack");
                        Warrior.setHealth(Warrior.getHealth() - vampireAttack.getDamage());
                        System.out.println("You have received " + vampireAttack.getDamage() + " damage");
                        System.out.println("Your health is now " + Warrior.getHealth());
                        break;
                    case 2:
                        System.out.println("Bite");
                        Warrior.setHealth(Warrior.getHealth() - vampireAttack1.getDamage());
                        System.out.println("You have received " + vampireAttack1.getDamage() + " damage");
                        System.out.println("Your health is now " + Warrior.getHealth());
                        break;
                    case 3:
                        System.out.println("Soul Siphon");
                        Warrior.setHealth(Warrior.getHealth() - vampireAttack2.getDamage());
                        System.out.println("You have received " + vampireAttack2.getDamage() + " damage");
                        System.out.println("Your health is now " + Warrior.getHealth());
                        break;
                }

                if (Warrior.getHealth() <= 0) {
                    System.out.println("You have died! The vampire has won the battle!");
                    gameOver = true;
                }
                playerTurn = false;
            }
        }
    }
}

