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
import main.berserkPotion;
import main.lastBreathPotion;

public class Main {
    public static double size = 0;


    public static void main(String[] args) {

        GeneralManager generalManager = new GeneralManager();
        generalManager.iniciate();
        generalManager.combat();
    }
}

