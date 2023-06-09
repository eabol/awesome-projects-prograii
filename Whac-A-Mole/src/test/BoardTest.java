package test;

import main.Board;
import main.Hole;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class BoardTest {

    @Test
    public void testShowBoardEmpty() {
        int boardSize = 3;
        Board board = new Board(boardSize);
        String expectedOutput = "O O O \nO O O \nO O O \n";

        // Redireccionar la salida estándar para capturarla en un StringBuilder
        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public void write(int b) {
                output.append((char) b);
            }
        }));

        // Llamar al método showBoard()
        board.showBoard();

        // Restaurar la salida estándar
        System.setOut(System.out);

        // Verificar la salida
        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testBeatenHole() {
        Board board = new Board(3);
        int position = 4;
        Hole expectedHole = new Hole();

        // Marcar el agujero esperado como golpeado
        expectedHole.setMole(null);

        // Llamar al método beatenHole()
        Hole resultHole = board.beatenHole(position);

        // Verificar que el agujero devuelto sea igual al agujero esperado
        Assertions.assertEquals(expectedHole, resultHole);
    }

    static class HoleTest {

    }
}