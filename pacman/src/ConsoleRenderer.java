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

            printMaze(game.getMaze());
            printCharacter(game.getPacman());
            game.start();

            while (game.isRunning()) {
                readUserInput(terminal);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void printMaze(Maze maze) throws IOException, InterruptedException {
        TextGraphics textGraphics = screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.WHITE_BRIGHT);
        textGraphics.putString(0, maze.getHeight(), "Score: " + "10", SGR.BOLD);

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell cell = maze.getCell(j, i);
                if (cell.hasDot()) {
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