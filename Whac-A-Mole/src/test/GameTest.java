package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import main.Board;
import main.Game;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        Board board = new Board();
        game = new Game(board);
    }

    @Test
    public void testShowMenu() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        game.showMenu();

        String output = outputStream.toString().trim();

        Assert.assertEquals("Menu is displayed", "Show Menu", output);
    }

    @Test
    public void testStartToPlay() {
        String input = "1\nN\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Game game = new Game(new Board(), scanner);
        game.startToPlay();

        String output = outputStream.toString().trim();

        Assert.assertTrue("Board is displayed", output.contains("Board is displayed"));
        Assert.assertTrue("Game over message is displayed", output.contains("Game over!"));
    }
}