package main.game;

import main.renderer.ConsoleRenderer;
import main.renderer.Renderer;
public class PacmanGame {
    private Game game;
    private Renderer renderer;

    public PacmanGame() {
        game = new Game();
        renderer = new ConsoleRenderer();
        renderer.renderGame(game);
    }

    public static void main(String[] args) {
        new PacmanGame();
    }
}