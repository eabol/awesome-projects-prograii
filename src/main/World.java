package src.main;

import java.util.ArrayList;

import src.main.Characters.Character;

public class World {
    public ArrayList<Character> characters;
    public ArrayList<Maze> levels;
    public Character player;
    public Time time;

    public World(Character player, ArrayList<Maze> levels, ArrayList<Character> characters, Time time) {
        this.player = player;
        this.levels = levels;
        this.characters = characters;
        this.time = time;
    }

    public void updateWorld() {

    }
}
