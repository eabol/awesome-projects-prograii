package Vacuum;

import java.util.Random;
class Board {
    private final int[][] map;
    private final int width;
    private final int height;
    private int totalDirt;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;
        this.map = new int[height][width];
        this.totalDirt = 0;
    }
    public boolean isValidToMove(int x,int y){
        return x > 0 && x < height - 1 && y > 0 && y < width - 1;
    }

    public void generateMap() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if ((row == 0 || row == height - 1)&&(column == 0 || column == width - 1)) {
                    // Corners
                    map[row][column] = 16;
                } else if ((row == 0 || row == height - 1)) {
                    // Vertical walls
                    map[row][column] = 15;
                } else if ((column == 0 || column == width -1)){
                    // horizontal walls
                    map[row][column] = 14;
                //} else if (i == 1 && j == 1) {
                    // Aspiradora
                    //map[i][j] = 8;
               // } else if (i == 4 && j == 6) {
                    // Sofá
                   // map[i][j] = 7;
                //} else if (i == 8 && j == 11) {
                    // Mesa
                    //map[i][j] = 10;
                } else {
                    // Zona sucia aleatoria
                    if (((int)(Math.random()*100) + 1 > 75)){
                        map[row][column] = (int)(Math.random()*4 +1);
                        totalDirt += map[row][column];
                    }
                }
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(getTileSkin(i, j));
            }
            System.out.println();
        }
    }
    public void addFurnitures(){
        Random random = new Random();

        //Sofa
        int sofaX = random.nextInt(height);
        int sofaY = random.nextInt(width-2);
        map[sofaX][sofaY] = 7;
        map[sofaX][sofaY+1] = 8;

        //Table
        int tableX = random.nextInt(height-3);
        int tableY = random.nextInt(width-3);
        map[tableX][tableY] = 9;
        map[tableX][tableY+1] = 10;
        map[tableX][tableY+2] = 11;
        map[tableX+1][tableY] = 12;
        map[tableX+1][tableY+1] = 13;



    }

    public String getTileSkin(int x, int y) {
        return switch (map[x][y]) {
            case 0 -> " · ";    //Clean
            case 1 -> "ooo";    //Dirt1
            case 2 -> "***";    //Dirt2
            case 3 -> "OOO";    //Dirt3
            case 4 -> "000";    //Dirt4
            case 5 -> "(O)";    //Vacuum.VacuumCleaner
            case 6 -> "\"^\"";  //Vacuum.Cat
            case 7 -> "[##";    //Sofa.left
            case 8 -> "##]";    //Sofa.right
            case 9 -> "+--";    //Table.leftCorner
            case 10 -> "--+";   //Table.rightCorner
            case 11 -> "|##";   //Table.centerLeft
            case 12 -> "###";   //Table.center
            case 13 -> "##|";   //Table.centerRight
            case 14 -> "|";     //Wall.vertical
            case 15 -> "---";   //Wall.horizontal
            case 16 -> "+";     //Wall.corner
            default -> "    ";  //Empty
        };
    }

    public void cleanTile(int x, int y) {
        if (map[x][y] > 0) {
            map[x][y]--;
            totalDirt--;
        }
    }

    public int getTileDirtyLevel(int x, int y){
        if(!isValidToMove(x, y)){
            throw new IllegalArgumentException("Invalid WorkinProgress.Tile Coordinates");

        }
        return map[x][y];
    }

    public int getTotalDirt() {
        return totalDirt;
    }
}
