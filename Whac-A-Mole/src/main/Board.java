package main;

import main.Hole;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Hole>> holes;

    public Board() {
        holes = new ArrayList<>();
    }

    public Board(int holes) {
        this();
        for (int i = 0; i < holes; i++) {
            addRowOfHoles();
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

    public Hole beatenHole(int position) {
        if (position >= 0 && position < getTotalHoles()) {
            int row = position / getColumns();
            int col = position % getColumns();
            return holes.get(row).get(col);
        } else {
            throw new IndexOutOfBoundsException("Invalid hole position");
        }
    }

    public int getTotalHoles() {
        int total = 0;
        for (List<Hole> row : holes) {
            total += row.size();
        }
        return total;
    }

    private int getColumns() {
        if (!holes.isEmpty()) {
            return holes.get(0).size();
        }
        return 0;
    }

    private void addRowOfHoles() {
        List<Hole> row = new ArrayList<>();
        holes.add(row);
    }
}