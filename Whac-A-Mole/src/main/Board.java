package main;

import java.util.ArrayList;
import java.util.List;
import main.Hole;

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
        StringBuilder boardBuilder = new StringBuilder();
        for (List<Hole> row : holes) {
            for (Hole hole : row) {
                if (hole.getSmackableCharacter() != null) {
                    boardBuilder.append(hole.getSmackableCharacter().getName()).append(" ");
                } else {
                    boardBuilder.append("O ");
                }
            }
            boardBuilder.append("\n");
        }
        System.out.println(boardBuilder.toString());
    }

    public Hole beatenHole(int position) {
        int row = position / holes.size();
        int col = position % holes.size();
        Hole hole = holes.get(row).get(col);
        hole.setMole(null);
        return hole;
    }
}
