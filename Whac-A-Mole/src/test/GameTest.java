package test;

import main.Board;
import main.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameTest {
    @Test
    public void testStartToPlay() {
        // Configurar entrada del usuario simulada
        String simulatedUserInput = "0\nN\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(inputStream);

        // Capturar salida del sistema
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Crear instancia de Game y ejecutar el juego simulado
        Board board = new Board(3, 4);
        Game game = new Game(board, new Scanner(System.in));
        game.startToPlay();

        // Verificar la salida esperada
        String expectedOutput = "0 0 0 0" + System.lineSeparator() +
                "0 0 0 0" + System.lineSeparator() +
                "0 0 0 0" + System.lineSeparator() +
                "Select a hole to hit:" + System.lineSeparator() +
                "Hit at position 0" + System.lineSeparator() +
                "Do you want to continue playing? (Y/N)" + System.lineSeparator() +
                "Game over!" + System.lineSeparator();
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}