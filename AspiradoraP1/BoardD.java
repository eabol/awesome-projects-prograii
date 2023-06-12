import java.util.Random;
class BoardD {
    private int[][] map;
    private int width;
    private int height;
    private int totalDirt;
    private int trashCapacity;
    private int currentTrash;
    private Random random;

    public BoardD(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
        this.totalDirt = 0;
        this.trashCapacity = 20;
        this.currentTrash = 0;
        this.random = new Random();
    }
    public boolean isValidToMove(int x,int y){
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return false;
        }
        return true;
    }

    public void generateMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || i == width - 1 || j == 0 || j == height - 1) {
                    // Paredes
                    map[i][j] = 9;
                } else if (i == 1 && j == 1) {
                    // Aspiradora
                    map[i][j] = 8;
                } else if (i == 4 && j == 6) {
                    // Sofá
                    map[i][j] = 7;
                } else if (i == 8 && j == 11) {
                    // Mesa
                    map[i][j] = 10;
                } else {
                    // Zona sucia aleatoria
                    if (((int)(Math.random()*100) + 1 > 50)){
                        map[i][j] = (int)(Math.random()*4 +1);
                    }
                    int dirtLevel = random.nextInt(5);
                    map[i][j] = dirtLevel;
                    totalDirt += dirtLevel;
                }
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(getTileSkin(i, j));
            }
            System.out.println();
        }
    }

    public String getTileSkin(int x, int y) {
        switch (map[x][y]) {
            case 0:
                return "  ·  ";
            case 1:
                return "  o  ";
            case 2:
                return "  *  ";
            case 3:
                return "  O  ";
            case 4:
                return "  0  ";
            case 7:
                return " [##]" ;
            case 8:
                return " (O) " ;
            case 9:
                return "  |  ";
            default:
                return "    ";
        }
    }

    public void cleanTile(int x, int y) {
        if (map[x][y] > 0) {
            currentTrash++;
            map[x][y]--;
            totalDirt--;
        }
    }

    public int getTileDirtyLevel(int x, int y){
        if(!isValidToMove(x, y)){
            throw new IllegalArgumentException("Invalid Tile Coordinates");

        }
        return map[x][y];
    }

    public int getTotalDirt() {
        return totalDirt;
    }
}
