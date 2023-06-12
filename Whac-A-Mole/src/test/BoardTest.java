package test;

import main.Board;
import main.Hole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setup() {
        board = new Board(3);
    }

    @Test
    public void testShowBoard() {
        board.showBoard();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testBeatenHole() {
        // Supongamos que hay un personaje en el segundo agujero de la primera fila
        Hole hole = new Hole();
        board.beatenHole(1).setSmackableCharacter(hole.getSmackableCharacter());

        // Verificar si el agujero ha sido golpeado
        Assert.assertTrue(board.beatenHole(1).isMoleInside());
        Assert.assertEquals("Mole inside: null", board.beatenHole(1).showMoleInside());
    }
}