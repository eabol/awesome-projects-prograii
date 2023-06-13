package game;

import renderer.ConsoleRenderer;
import renderer.Renderer;
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