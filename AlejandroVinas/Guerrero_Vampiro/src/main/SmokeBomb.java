package main;

public class SmokeBomb extends Equipment{

        public SmokeBomb(String name, int cuantity) {
            super(name,cuantity);
        }

        public void hit (){
            System.out.println("You have used a smoke bomb to escape the vampire");
            System.out.println("You run away like a coward");
            System.out.println("You have lost the game");
            System.exit(0);
        }

}
