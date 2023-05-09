package main;

import java.util.Random;
import main.warrior;
import main.potions;
import main.shield;

public class vampireAttack extends Weapons {
    public vampireAttack(int damage, double accuracy) {
        super(damage, accuracy);
    }
    warrior enemy = new warrior("enemy", 100, 10, 10);
    potions berserk = new potions("Berserk", 1);

    shield shield = new shield("Shield", 1);
    public void vampireAttacks() {
        String[] attacks = {"Claw", "Bite", "Soul Syphon"};
        Random rand = new Random();
        int attackIndex = rand.nextInt(attacks.length);
        String selectedAttack = attacks[attackIndex];
        switch (selectedAttack) {
            case "Claw" -> {
                setDamage(10);
                int randomNum = rand.nextInt(100);
                if (randomNum >=89) {
                    System.out.println("The vampire missed!");
                    break;
                } else {

                    if(berserk.berserkActive == true && randomNum < 89) {
                    double damage = this.getDamage()/2;
                    enemy.setHealth(enemy.getHealth() - damage);
                    } else if (berserk.rockActive==true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    } else if (shield.activateShield() == true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    }
                }
            }
            case "Bite" -> {
                setDamage(15);
                int randomNum = rand.nextInt(100);
                if (randomNum >=59) {
                    System.out.println("The vampire missed!");
                    break;
                }  else {
                    if(berserk.berserkActive == true && randomNum < 89) {
                        double damage = this.getDamage()/2;
                        enemy.setHealth(enemy.getHealth() - damage);
                    } else if (berserk.rockActive==true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    }else if (shield.activateShield() == true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    }
                }
            }
            case "Soul Syphon" -> {
                setDamage(20);
                int randomNum = rand.nextInt(100) + 1;
                if (randomNum >=40) {
                    System.out.println("The vampire missed!");
                    break;
                }  else {
                    if(berserk.berserkActive == true && randomNum < 89) {
                        double damage = this.getDamage()/2;
                        enemy.setHealth(enemy.getHealth() - damage);
                    } else if (berserk.rockActive==true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    }else if (shield.activateShield() == true) {
                        double damage = this.getDamage() / 4;
                        enemy.setHealth(enemy.getHealth() - damage);
                    }
                }
            }
        }
    }
}

