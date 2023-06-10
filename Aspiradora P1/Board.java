import java.util.ArrayList;

;

    public class Board {
        private Tile[][] matrix;

        public Board(int rows, int columns, /* Argumentos adicionales para Tile */) {
            matrix = new Tile[rows][columns];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = new Tile(/* Argumentos para Tile */);
                }
            }
        }

        public ArrayList<Tile> getArrayList() {
            ArrayList<Tile> tileList = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    tileList.add(matrix[i][j]);
                }
            }
            return tileList;
        }

        public void printArrayList() {
            ArrayList<Tile> tileList = getArrayList();
            for (Tile tile : tileList) {
                System.out.println(tile.toString());
            }
        }
    }

