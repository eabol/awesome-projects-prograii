package main.renderer;
import main.game.Game;
import main.game.Ghost;
import main.game.Position;

public interface Renderer {
    void renderGame(Game game);
    void close() throws Exception;
    void movePacman(Position previousPosition) throws Exception;
    void moveGhost(Ghost ghost, Position previousPosition) throws Exception;
    void printWinScreen() throws Exception;
}