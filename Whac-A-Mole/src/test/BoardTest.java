import main.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    public void testShowBoardEmpty() {
        Board board = new Board(3);
        String expectedOutput = "O O O \nO O O \nO O O \n";

        StringBuilder output = new StringBuilder();
        System.setOut(new java.io.PrintStream(new java.io.ByteArrayOutputStream() {
            public void write(int b) {
                output.append((char) b);
            }
        }));

        board.showBoard();

        System.setOut(System.out);

        Assertions.assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testBeatenHole() {
        Board board = new Board(3);
        int position = 4;
        Hole expectedHole = new Hole();

        expectedHole.setMole(null);

        Hole resultHole = board.beatenHole(position);

        Assertions.assertEquals(expectedHole, resultHole);
    }
}