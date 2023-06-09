package core.character;

import core.Terrain;
import core.character.GameCharacter;
import java.util.Random;

public class NonPlayableGameCharacter extends GameCharacter {
    public NonPlayableGameCharacter (Terrain terrain) {
        this.currentTerrain = terrain;
        setTransport(terrain);
    }

    @Override
    public void tryMove() {
        Random random = new Random();
        int direction = random.nextInt(4); // Generate a random number between 0 and 3

        switch (direction) {
            case 0:
                System.out.println("Character moved up");
                break;
            case 1:
                System.out.println("Character moved down");
                break;
            case 2:
                System.out.println("Character moved left");
                break;
            case 3:
                System.out.println("Character moved right");
                break;
        }
    }
}
