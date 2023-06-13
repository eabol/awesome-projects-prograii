package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Hole>> holes;

    public Board(int rows, int columns, boolean normal) {
        holes = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            addRowOfHoles(columns, normal);
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

    private void addRowOfHoles(int columns, boolean normal) {
        List<Hole> row = new ArrayList<>();
        Luck luck = new Luck();
        for (int i = 0; i < columns; i++) {
            if (!normal)
            {
                if (luck.getPositiveLuck()) {
                    row.add(new Hole(new Mole()));
                } else {
                    row.add(new Hole());
                }
            }
            else {
                row.add(new Hole());
            }

        }
        holes.add(row);
    }
}