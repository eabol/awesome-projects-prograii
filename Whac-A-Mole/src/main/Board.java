package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Hole>> holes;

    public Board(int rows, int columns) {
        holes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            addRowOfHoles(columns);
        }
    }

    public void showBoard() {
        for (List<Hole> row : holes) {
            for (Hole hole : row) {
                System.out.print(hole.getAspect() + " ");
            }
            System.out.println();
        }
    }

    public Hole getHole(int row, int column) {
        if (isValidPosition(row, column)) {
            return holes.get(row).get(column);
        } else {
            throw new IndexOutOfBoundsException("Invalid hole position");
        }
    }

    public boolean isValidPosition(int row, int column) {
        return row >= 0 && row < getRowCount() && column >= 0 && column < getColumnCount();
    }

    public int getRowCount() {
        return holes.size();
    }

    public int getColumnCount() {
        if (!holes.isEmpty()) {
            return holes.get(0).size();
        }
        return 0;
    }

    private void addRowOfHoles(int columns) {
        List<Hole> row = new ArrayList<>();
        for (int i = 0; i < columns; i++) {
            row.add(new Hole());
        }
        holes.add(row);
    }
}