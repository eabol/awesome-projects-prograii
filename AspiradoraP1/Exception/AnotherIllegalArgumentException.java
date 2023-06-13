package Exception;

public class AnotherIllegalArgumentException extends Exception {
    public class Board {
    }
    private char[][] map;

    public void Board(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("The number of rows and columns must be greater than 0");
        }
        map = new char[rows][columns];
    }
}
