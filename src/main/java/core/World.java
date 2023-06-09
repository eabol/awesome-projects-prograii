package core;

import core.Terrain;
import core.character.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class World {

    private ArrayList<ArrayList<GameCharacters>> NPCs;
    private ArrayList<Maze> maps;
    private GameCharacters player;
    private Time time;
    private int currentMaze;
    private int[][][] mazesData = {
            {
                    { 0, 0, 0, 0, 1, 0, 1, 0, 2, 3, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                    { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                    { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 },
                    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 7, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
                    { 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 },
                    { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
                    { 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6 },
                    { 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7 },
                    { 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8 }
            }
    };

    public World() {
        this.time = new Time(6, 0, 15);
        this.maps = generateLevels(mazesData);
        this.player = new Player();
        this.NPCs = generateCharacters();
        this.currentMaze = 0;
    }

    public void updateWorld() {
        player.tryMove();
        NPCs.get(currentMaze).forEach(gameCharacter -> gameCharacter.tryMove());
        time.advanceTime();
    }

    private ArrayList<ArrayList<GameCharacters>> generateCharacters() {
        ArrayList<ArrayList<GameCharacters>> arrayList = new ArrayList<>();
        for (int index = 0; index < maps.size(); index++) {
            ArrayList<GameCharacters> map = new ArrayList<>();
            Random random = new Random();

            for (int num = random.nextInt((8 - 5) + 1) + 5; num > 0; num--) {
                map.add(new NPC(
                        maps.get(index).getRandomOccupableTerrain()));
            }
            arrayList.add(map);
        }
        return arrayList;
    }

    public ArrayList<Maze> generateLevels(int[][][] mazesData) {
        ArrayList<Maze> arrayList = new ArrayList<>();
        for (int[][] map : mazesData) {
            arrayList.add(new Maze(map));
        }
        return arrayList;
    }

    public Maze getCurrentMaze() {
        return maps.get(currentMaze);
    }
}
