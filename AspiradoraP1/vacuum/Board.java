package vacuum;
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
                } else {
                    // generating dirt patches
                    if (((int)(Math.random()*100) + 1 > 75)){
                        map[row][column] = (int)(Math.random()*4 +1);
                        totalDirt += map[row][column];
                    }
                }
            }
        }
    }

    public void addFurniture() {
        Random random = new Random();
        int p = 0;
        //Tables
        do {
            int tableX = random.nextInt(height - 5) + 1;
            int tableY = random.nextInt(width - 5) + 1;
            for (int j = 0; j < 3; j++){
                for (int k = 0; k < 3; k++){
                    if ((map[tableX+k][tableY+j]<=6)&&!((tableX+k == 5)&&((tableY+j == 12)))){
                        p++;

                    }
                }
            }
            if (p%9==0){
                map[tableX][tableY] = 9;
                map[tableX][tableY + 1] = 15;
                map[tableX][tableY + 2] = 10;
                map[tableX + 1][tableY] = 11;
                map[tableX + 1][tableY + 1] = 12;
                map[tableX + 1][tableY + 2] = 13;
                map[tableX + 2][tableY] = 9;
                map[tableX + 2][tableY + 1] = 15;
                map[tableX + 2][tableY + 2] = 10;
            }
        } while ((random.nextBoolean()));


        //Sofas
        do {
            int sofaX = random.nextInt(height - 2) + 1;
            int sofaY = random.nextInt(width - 3) + 1;
            if (((map[sofaX][sofaY+1]<=6)&&(map[sofaX][sofaY]<7))&&!((sofaX == 5)&&((sofaY == 12)||(sofaY+1 == 12)))){
                map[sofaX][sofaY] = 7;
                map[sofaX][sofaY + 1] = 8;
            }
        } while (random.nextBoolean()||random.nextBoolean());
    }



    public void printMap(VacuumCleaner P1, Cat C1) {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                if ((column == C1.getXCoordinate())&&(row == C1.getYCoordinate()) && (C1.isPresent)){
                    System.out.print("\"^\"");
                } else if ((column == P1.getXCoordinate())&&(row == P1.getYCoordinate())){
                    System.out.print("(O)");
                } else {
                    System.out.print(getTileSkin(row, column));
                }
            }
            System.out.println();
        }
    }

    public String getTileSkin(int x, int y) {
        return switch (map[x][y]) {
            case 0 -> " · ";    //Clean
            case 1 -> "ooo";    //Dirt1
            case 2 -> "***";    //Dirt2
            case 3 -> "OOO";    //Dirt3
            case 4 -> "000";    //Dirt4
            case 5 -> "(O)";    //VacuumCleaner
            case 6 -> "\"^\"";  //Cat
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

    public void cleanTile(int x, int y, VacuumCleaner P1,Cat C1) {
        if (map[x][y] > 0) {
            Cleanable cleanable= getCleanableObject(x,y);
            if (cleanable != null){
                cleanable.clean();
            }
            map[x][y]--;
            totalDirt--;
            if (totalDirt == 0) {
                System.out.println("¡NICE! ¡You cleaned all the house!");
                printMap(P1,C1);
                System.out.println("Total steps made:" +P1.getSteps());
                System.out.println("You Won!");
                System.exit(0);
            }
        }
    }
    private Cleanable getCleanableObject(int x, int y){
        if (map[x][y] >0){
            return new Cleanable() {
                @Override
                public void clean() {

                }
            };

        }return null;
    }

    public int getTotalDirt() {
        return totalDirt;
    }
}
