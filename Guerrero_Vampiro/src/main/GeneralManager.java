package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeneralManager {
    warrior Warrior;
    shield Shield;
    Vampire Vampire;
    WarriorActions WarriorActions;
    Random random ;
    int min = 1;
    int max = 3;
    vampireAttack vampireAttack;

    berserkPotion BerserkPotion ;
    lastBreathPotion LastBreathPotion ;
    malhitePotion MalhitePotion ;
    seagullPotion SeagullPotion;
    twitterPotion TwitterPotion;
    ;
    ArrayList<Equipment> EquipmentArrayList ;
    int ShieldCounter=0;

    public void iniciate (){



        Warrior = new warrior("Warrior", 100);
        Vampire = new Vampire("Vampire", 100);
        WarriorActions = new WarriorActions();
        random = new Random();
        int min = 1;
        int max = 3;
        vampireAttack = new vampireAttack(5, 90);
        Shield = new shield("Shield", 1);
        BerserkPotion = new berserkPotion("Berserk Potion",1);
        LastBreathPotion = new lastBreathPotion("Last Breath Potion", 1);
        MalhitePotion = new malhitePotion("RockSolid Potion", 1);
        SeagullPotion = new seagullPotion("Seagull Eye Potion", 1);
        TwitterPotion = new twitterPotion("Twitter Essence", 1);
        EquipmentArrayList = new ArrayList<>();
        EquipmentArrayList.add(BerserkPotion);
        EquipmentArrayList.add(LastBreathPotion);
        EquipmentArrayList.add(MalhitePotion);
        EquipmentArrayList.add(SeagullPotion);
        EquipmentArrayList.add(TwitterPotion);

        for (int i = 0; i < EquipmentArrayList.size(); i++) {
            System.out.println(EquipmentArrayList.get(i));
        }

    }
    public void combat(){
        boolean playerTurn = true;
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("While walking through the forest you encounter a Vampire that looks at you with malicious intent");
        while (!gameOver) {
            if (playerTurn) {
                if (Shield.isShieldActive) {
                    ShieldCounter=ShieldCounter+1;
                }else if(ShieldCounter==3){
                    Shield.isShieldActive=false;
                    ShieldCounter=0;
                }
                System.out.println("It's your turn, choose an action: ");
                System.out.println("1. Attack");
                System.out.println("2. Open bag");
                System.out.println("3. Use shield");
                int action = scanner.nextInt();

                switch (action) {
                    case 1:
                        System.out.println("You have chosen to attack");
                        System.out.println("Choose a weapon: ");
                        System.out.println("1. Sword");
                        System.out.println("2. Handaxe");
                        System.out.println("3. Flail");
                        int weapon = scanner.nextInt();
                        switch (weapon) {
                            case 1:
                                System.out.println("Sword");
                                WarriorActions.attackSword();
                                break;
                            case 2:
                                System.out.println("Handaxe");
                                WarriorActions.attackHandaxe();
                                break;
                            case 3:
                                System.out.println("Flail");
                                WarriorActions.attackFlail();
                                break;
                            default:
                                System.out.println("You have chosen an invalid option");
                                break;

                        }
                        break;
                    case 2:
                        System.out.println("You have opened your bag");
                        WarriorActions.checkEquipment(EquipmentArrayList);
                        System.out.println("Choose an item to use: ");
                        System.out.println("1. Berserk Potion");
                        System.out.println("2. Last Breath Potion");
                        System.out.println("3. Rock Solid Potion");
                        System.out.println("4. Seagull Eye Potion");
                        System.out.println("5. Twitter Essence Potion");

                        int potion = scanner.nextInt();
                        switch (potion) {
                            case 1:
                                System.out.println("Berserk Potion");
                                Warrior.setHealth(Warrior.getHealth());
                                BerserkPotion.berserkPotion(Warrior);
                                break;
                            case 2:
                                System.out.println("Last Breath");
                                Warrior.setHealth(Warrior.getHealth());
                                LastBreathPotion.lastBreath(Warrior);
                                break;
                            case 3:
                                System.out.println("Rock Solid");
                                Warrior.setHealth(Warrior.getHealth());
                                MalhitePotion.rockSolid(Warrior);
                                break;
                            case 4:
                                System.out.println("Seagull Eye");
                                SeagullPotion.seagullEye(Warrior);
                                break;
                            case 5:
                                System.out.println("Twitter Essence");
                                TwitterPotion.twitterEssence(Warrior);
                                break;
                            default:
                                System.out.println("You have chosen an invalid option");
                                break;
                             }
                    case 3:
                        System.out.println("Shield");
                        Warrior.setHealth(Warrior.getHealth());
                        WarriorActions.useShield(Shield);
                        System.out.println("You have used the shield. The vampire's next attacked will deal less damage.");
                        break;

                        }
                        break;
                }if (Vampire.getHealth() <= 0) {
                    System.out.println("The vampire has bean defeated! You win!");
                    gameOver = true;
                    playerTurn = false;
                } else {
                System.out.println("It's the vampire's turn");
                System.out.println("The vampire attacks you");
                vampireAttack.vampireAttacks();

                if (Warrior.getHealth() <= 0) {
                    System.out.println("You have died! The vampire has won the battle!");
                    gameOver = true;
                }
                playerTurn = false;
            }
        }
    }

}
