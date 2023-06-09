package main.core;

import java.util.Scanner;

public class Management {
    public Management() {
    }
    public int askNumber() {
        Scanner number = new Scanner(System.in);
        int num = number.nextInt();
        return num;
    }
    public int selectMachine(){

        System.out.println("Which machine would you like to select?");
        switch (askNumber()) {
            case 1:
                System.out.println("You selected the Drinking Machine");
                return 1;
            case 2:
                System.out.println("You selected the Healthy Snack Machine");
                return 2;

            case 3:
                System.out.println("You selected the Unhealthy Snack Machine");
                return 3;
        }
        return 0;
    }
}
