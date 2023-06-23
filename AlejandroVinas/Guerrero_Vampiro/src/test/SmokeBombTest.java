package test;

import org.junit.Test;

public class SmokeBombTest extends Equipment{

    public SmokeBombTest() {
        super("SmokeBomb", 1);
    }

    @Test
    public void hit (){
        System.out.println("You have used a smoke bomb to escape the vampire");
        System.out.println("You run away like a coward");
        System.out.println("You have lost the game");
        System.exit(0);
    }
}
