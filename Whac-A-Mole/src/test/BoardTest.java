package test;

import main.Board;
import main.Hole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {
    private Board board;

    @org.junit.jupiter.api.Test
    public void testGetHole() {
        Board board = new Board(3, 4);

        // Verificar que se obtenga el agujero correcto en diferentes posiciones
        Hole hole1 = board.getHole(0, 0);
        Assertions.assertNotNull(hole1);

        Hole hole2 = board.getHole(1, 2);
        Assertions.assertNotNull(hole2);

        Hole hole3 = board.getHole(2, 3);
        Assertions.assertNotNull(hole3);

        // Verificar que se obtenga una excepción al intentar obtener un agujero fuera de los límites
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getHole(3, 2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getHole(1, 4));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> board.getHole(-1, 0));
    }

    @org.junit.jupiter.api.Test
    public void testIsValidPosition() {
        Board board = new Board(3, 4);

        // Verificar que las posiciones dentro de los límites sean consideradas válidas
        Assertions.assertTrue(board.isValidPosition(0, 0));
        Assertions.assertTrue(board.isValidPosition(2, 3));

        // Verificar que las posiciones fuera de los límites sean consideradas inválidas
        Assertions.assertFalse(board.isValidPosition(3, 2));
        Assertions.assertFalse(board.isValidPosition(1, 4));
        Assertions.assertFalse(board.isValidPosition(-1, 0));
    }

    @org.junit.jupiter.api.Test
    public void testGetRowCount() {
        Board board = new Board(3, 4);
        Assertions.assertEquals(3, board.getRowCount());
    }

    @org.junit.jupiter.api.Test
    public void testGetColumnCount() {
        Board board = new Board(3, 4);
        Assertions.assertEquals(4, board.getColumnCount());
    }

    static class LuckTest {

        @Test
        void getPositiveLuck() {
        }

        @Test
        void getNegativeLuck() {
        }
    }
}