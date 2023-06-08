package main;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Hole>> holes;

    public Board() {
        holes = new ArrayList<>();
    }

    public Board(int holes) {
        this.holes = new ArrayList<>();
        initializeHoles(holes);
    }

    private void initializeHoles(int numHoles) {
        for (int i = 0; i < numHoles; i++) {
            List<Hole> row = new ArrayList<>();
            for (int j = 0; j < numHoles; j++) {
                row.add(new Hole());
            }
            this.holes.add(row);
        }
    }

    public void showBoard() {
        for (List<Hole> row : holes) {
            for (Hole hole : row) {
                System.out.print(hole.isMoleInside() ? "M " : "O ");
            }
            System.out.println();
        }
    }

    public Hole beatenHole(int position) {
        int row = position / holes.size();
        int col = position % holes.size();
        Hole hole = holes.get(row).get(col);
        hole.setMole(null);
        return hole;
    }
}
