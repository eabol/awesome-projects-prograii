package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GeneralManager {
    main.Warrior Warrior;

    Vampire Vampire;
    WarriorActions WarriorActions;
    Random random;
    int min = 1;
    int max = 3;
    VampireAttack vampireAttack;
    Dagger Dagger;
    ;
    ArrayList<Equipment> EquipmentArrayList;

    SmokeBomb SmokeBomb;
    Intimidate Intimidate;


    boolean playerTurn = true;


    public void iniciate() {

        Intimidate = new Intimidate(0, 14);
        SmokeBomb = new SmokeBomb("Smoke Bomb", 1);
        Dagger = new Dagger("Dagger", 10);
        EquipmentArrayList = new ArrayList<>();
        Warrior = new Warrior("Warrior", 100);
        Vampire = new Vampire("Vampire", 100);
        WarriorActions = new WarriorActions();
        random = new Random();
        int min = 1;
        int max = 3;
        vampireAttack = new VampireAttack(5, 90);

        EquipmentArrayList.add(Dagger);
        EquipmentArrayList.add(SmokeBomb);


    }

    public void combat() {
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("While walking through the forest you encounter a Vampire that looks at you with malicious intent");
        if (Warrior.getHealth() > 0.0 || Vampire.getHealth() > 0.0) {
            while (!gameOver) {
                if (playerTurn) {

                    System.out.println("It's your turn, choose an action: ");
                    System.out.println("1. Attack");
                    System.out.println("2. Open bag");
                    System.out.println("3. Try to intimidate the vampire");
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
                                    playerTurn = false;

                                    break;
                                case 2:
                                    System.out.println("Handaxe");
                                    WarriorActions.attackHandaxe();
                                    playerTurn = false;
                                    break;
                                case 3:
                                    System.out.println("Flail");
                                    WarriorActions.attackFlail();
                                    playerTurn = false;
                                    break;
                                default:
                                    System.out.println("You have chosen an invalid option");
                                    playerTurn = false;
                                    break;

                            }
                            break;
                        case 2:
                            System.out.println("You have opened your bag");
                            System.out.println("Choose an item to use: ");
                            System.out.println("1.Dagger");
                            System.out.println("2.Smoke Bomb");

                            int potion = scanner.nextInt();
                            switch (potion) {
                                case 1:
                                    System.out.println("Dagger");
                                    WarriorActions.attackDagger();
                                    playerTurn = false;
                                    break;
                                case 2:
                                    System.out.println("Smoke Bomb");
                                    WarriorActions.NigerunDayo();
                                    playerTurn = false;
                                    break;
                                default:
                                    System.out.println("You have chosen an invalid option");
                                    playerTurn = false;
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("You shout at the vampire");
                            WarriorActions.Spooky();
                            playerTurn = false;
                            break;

                    }

                    if (!playerTurn) {
                        if (Vampire.getHealth() > 0) {
                            System.out.println("It's the vampire's turn");
                            System.out.println("The vampire attacks you");
                            vampireAttack.vampireAttacks();
                        } else {
                            Vampire.VampireDeath();
                            gameOver = true;
                        }

                    }


                }
                playerTurn = true;

            }
        }else{
            boolean b = gameOver == true;
            if (gameOver == true){
                if (Warrior.getHealth() <= 0.0) {
                    System.out.println("You have died! The vampire has won the battle!");
                } if (Vampire.getHealth() <= 0.0){
                    System.out.println("The vampire has been defeated! You win!");
                }
            }
        }

        }




    }












