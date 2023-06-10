import java.util.ArrayList;



    public class Board {
        private Tile[][] matrix;
        private int rows;
        private int columns;

        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            this.matrix = new Tile[rows][columns];
            initializeTiles();

        }

        private void initializeTiles() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = new Tile(i, j);
                }
            }
        }
        public  Tile getTile(int rows, int columns) {
            return matrix[rows][columns];
        }
        public void setTile(int rows, int columns, Tile tile) {
            matrix[rows][columns] = tile;
        }
        public int getRows() {
            return rows;
        }
        public int getColumns() {
            return columns;
        }
        public ArrayList<Tile>getAllTiles(){
            ArrayList<Tile> tiles = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    tiles.add(matrix[i][j]);
                }
            }
            return tiles;
        }
        public void printBoard() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.print(matrix[i][j].getTileType() + " ");
                }
                System.out.println();
            }
        }
    }



