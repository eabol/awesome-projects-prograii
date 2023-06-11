import java.util.ArrayList;



    public class Board {
        private Tiles[][] matrix;
        private int rows;
        private int columns;

        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            matrix = new Tiles[rows][columns];
            TileCleaned();

        }

        private void TileCleaned() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = new TileCleaned();
                }
            }
        }
        public  Tiles getTile(int x, int y) {
            return matrix[x][y];
        }
        public void setTile(int x, int y, Tiles tile) {
            matrix[x][y] = tile;//duda, no se si ponerle a lo que esta adentro de la matriz x y y o rows y columns
        }
        public int getRows() {
            return rows;
        }
        public int getColumns() {
            return columns;
        }

        public void printBoard() {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    Tiles tile = matrix[i][j];
                    if(tile instanceof TileCleaned){
                        System.out.print("0 ");
                }else if(tile instanceof TileDirty){
                        TileDirty tileDirty = (TileDirty) tile;
                        System.out.print(tileDirty.getLevelofDirt()+ " ");
                    }// hay que hacer un metodo de tile que nos de un tile de mueble
                }
                System.out.println();
            }
        }

    }



