public class PacmanGame {
    private Game game;
    private Renderer renderer;

    public PacmanGame() {
        game = new Game();
        renderer = new SwingRenderer();
    }

    public static void main(String[] args) {
        new PacmanGame();
    }
}