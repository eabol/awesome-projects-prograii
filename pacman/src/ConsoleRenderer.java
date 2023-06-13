import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class ConsoleRenderer implements Renderer {

    Terminal terminal = null;
    Screen screen = null;
    KeyStroke keyStroke = null;
    Game game;
    final int offset = 3;

    public void renderGame(Game game) {
        this.game = game;
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory
                .setInitialTerminalSize(
                        new TerminalSize(game.getMaze().getWidth() * offset, game.getMaze().getHeight() + 1));
        this.terminal = defaultTerminalFactory.createSwingTerminal();
        makeWindowVisible(terminal);
        try {
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            printStartScreen();

            if (terminal.readInput() != null) {
                startGame();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printMaze(Maze maze) throws IOException, InterruptedException {
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        printScore();
        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell cell = maze.getCell(new Position(j, i));
                if (cell.isFood()) {
                    printFood(new Position(j, i));
                } else if (cell.isWall()) {
                    printWall(new Position(j, i));
                } else {
                    printCell(new Position(j, i));
                }
            }
        }
        refresh();
    }

    private void readUserInput(Terminal terminal) throws IOException {
        keyStroke = terminal.pollInput();
        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
                this.close();
            }

            if (keyStroke.getKeyType() == KeyType.Character) {
                game.handleKeyPress(keyStroke.getCharacter(), this);
            }
        }
    }

    public void movePacman(Position previousPosition) throws IOException {
        printCharacter(game.getPacman(), previousPosition);
        printScore();
        refresh();
    }

    public void moveGhost(Ghost ghost, Position previousPosition) throws IOException {
        printCharacter(ghost, previousPosition);
        refresh();
    }

    private void printCharacter(Pacman pacman) throws IOException {
        TextGraphics textGraphics = this.screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        textGraphics.putString(pacman.getPosition().getXWithOffset(offset), pacman.getY(),
                " " + Symbols.SOLID_SQUARE + " ", SGR.BOLD);

        refresh();
    }

    private void printCharacter(Pacman pacman, Position previousPosition) throws IOException {
        printCell(previousPosition);
        printCharacter(pacman);
    }

    private void printCharacter(Ghost ghost) throws IOException {
        TextGraphics textGraphics = this.screen.newTextGraphics();
    
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(ghost.getPosition().getXWithOffset(offset), ghost.getPosition().getY(),
                " " + Symbols.SOLID_SQUARE + " ", SGR.BOLD);
    
        refresh();
    }
    
    private void printCharacter(Ghost ghost, Position previousPosition) throws IOException {
        printCell(previousPosition);
        printCharacter(ghost);
    }

    private void printCell(Position position) throws IOException {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.putString(position.getXWithOffset(offset), position.getY(), "   ");

    }

    private void printFood(Position position) {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.MAGENTA_BRIGHT);
        textGraphics.putString(position.getXWithOffset(offset), position.getY(), " o ", SGR.BOLD);
    }

    private void printWall(Position position) {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
        textGraphics.setForegroundColor(TextColor.ANSI.CYAN);
        textGraphics.putString(position.getXWithOffset(offset), position.getY(), " # ");
    }

    private void printScore() {
        TextGraphics textGraphics = this.screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        textGraphics.putString(0, game.getMaze().getHeight(), "Score: " + game.getScore(), SGR.BOLD);
    }

    private void printStartScreen() throws IOException {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        String initialText = "PACMAN - Press any key to start";
        textGraphics.putString(((game.getMaze().getWidth() / 2) * offset) - initialText.length() / 2,
                game.getMaze().getHeight() / 2, initialText, SGR.BOLD);
        refresh();
    }

    public void printWinScreen() throws Exception {
        game.stop();
        screen.clear();
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setBackgroundColor(TextColor.ANSI.YELLOW_BRIGHT);
        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        String initialText = "You have won the game with a score of " + game.getScore() + " points!";
        String restartText = "Press any key to restart";
        textGraphics.putString(((game.getMaze().getWidth() / 2) * offset) - initialText.length() / 2,
                game.getMaze().getHeight() / 2, initialText, SGR.BOLD);
        textGraphics.setBackgroundColor(TextColor.ANSI.WHITE_BRIGHT);
        textGraphics.setForegroundColor(TextColor.ANSI.BLACK_BRIGHT);
        textGraphics.putString(((game.getMaze().getWidth() / 2) * offset) - restartText.length() / 2,
                (game.getMaze().getHeight() / 2) + 3, restartText, SGR.BOLD);
        refresh();

        if (terminal.readInput() != null) {
            game.restart();
            startGame();
        }
    }

    private void startGame() throws Exception {
        game.start();
        printMaze(game.getMaze());
        printCharacter(game.getPacman());
        for (Ghost ghost : game.getGhosts()) {
            printCharacter(ghost);
        }
        game.startGhostMovement(this);
        while (game.isRunning()) {
            readUserInput(terminal);
        }
    }

    public void close() throws IOException {

        if (screen != null) {
            screen.close();
        }
        System.exit(0);
    }

    private void makeWindowVisible(Terminal terminal) {
        ((java.awt.Window) terminal).setVisible(true);
    }

    private void refresh() throws IOException {
        if (screen != null) {
            screen.refresh();
        }
    }
}