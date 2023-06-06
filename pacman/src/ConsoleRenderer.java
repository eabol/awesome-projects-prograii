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

    public void renderGame(Game game) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
        defaultTerminalFactory
                .setInitialTerminalSize(new TerminalSize(game.getMaze().getWidth() * 3, game.getMaze().getHeight()));
        this.terminal = defaultTerminalFactory.createSwingTerminal();
        makeWindowVisible(terminal);
        try {
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);
            screen.startScreen();

            printMaze(game.getMaze());
            this.printCharacter(game.getPacman());
            readUserInput(terminal);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void printMaze(Maze maze) throws IOException, InterruptedException {

        TextGraphics textGraphics = screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
        textGraphics.setForegroundColor(TextColor.ANSI.CYAN);

        for (int i = 0; i < maze.getHeight(); i++) {
            for (int j = 0; j < maze.getWidth(); j++) {
                Cell cell = maze.getCell(i, j);
                if (cell.hasDot()) {
                    textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
                    textGraphics.setForegroundColor(TextColor.ANSI.YELLOW);
                    textGraphics.putString(j == 0 ? 0 : j * 3, i, " o ", SGR.BOLD);
                } else if (cell.isWall()) {
                    textGraphics.setBackgroundColor(TextColor.ANSI.CYAN);
                    textGraphics.setForegroundColor(TextColor.ANSI.CYAN);
                    textGraphics.putString(j == 0 ? 0 : j * 3, i, " # ");
                } else {
                    textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);
                    textGraphics.putString(j == 0 ? 0 : j * 3, i, "   ");
                }
            }
        }
        refresh();
    }

    private void readUserInput(Terminal terminal) throws IOException {
            keyStroke = terminal.pollInput();

            if(keyStroke!= null){
                if(keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF) {
                    this.close();
                    
                }

                if (keyStroke.getKeyType() == KeyType.Character) {
                    System.out.println("KeyStroke: " + keyStroke.getCharacter());
                }
            }
    }
    
    private void printCharacter(Pacman pacman) throws IOException {
        TextGraphics textGraphics = this.screen.newTextGraphics();

        textGraphics.setBackgroundColor(TextColor.ANSI.WHITE);
        textGraphics.setForegroundColor(TextColor.ANSI.BLUE_BRIGHT);
        textGraphics.putString(pacman.getX() == 0 ? 0 : (pacman.getX() * 3) + 1, pacman.getY(), "C");

        refresh();
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