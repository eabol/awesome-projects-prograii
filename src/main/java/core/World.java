package main.java.core;
import main.java.core.Terrain;
import main.java.core.character.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class World {

    private ArrayList<ArrayList<GameCharacter>> NPCs;
    private ArrayList<Maze> maps;
    private GameCharacter player;
    private Time time;
    private int currentMaze;

    public World (String[][][] mazesData) {
        this.time = new Time(6,0,15);
        this.maps = generateLevels(mazesData);
        this.player = new PlayableGameCharacter();
        this.NPCs = generateCharacters();
        this.currentMaze = 0;
    }

    public void updateWorld() {
        player.tryMove();
        NPCs.get(currentMaze).forEach(gameCharacter -> gameCharacter.tryMove());
        time.advanceTime();
    }

    private ArrayList<ArrayList<GameCharacter>> generateCharacters() {
        ArrayList<ArrayList<GameCharacter>> arrayList = new ArrayList<>();
        for (int index = 0; index < maps.size(); index++){
            ArrayList<GameCharacter> map = new ArrayList<>();
            Random random = new Random();

            for (int num = random.nextInt((8 - 5) + 1) + 5; num > 0; num--) {
                map.add(new NonPlayableGameCharacter(
                        maps.get(index).getRandomOccupableTerrain())
                );
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public ArrayList<Maze> generateLevels (String[][][] data) {
        System.out.println("Generating levels...");

        ArrayList<Maze> arrayList = new ArrayList<>();
        for (String[][] map: data) {
            arrayList.add(new Maze(map));
        }
        return arrayList;
    }

    public Maze getCurrentMaze() {
        return maps.get(currentMaze);
    }
}
