public class Maze {
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int[][] map) {
        this.height = map.length;
        this.width = map[0].length;
        cells = new Cell[this.height][this.width];
        
        for(int i = 0; i < this.height ; i++) {
            for(int j = 0; j < this.width; j++) {
                cells[i][j] = new Cell(new Position(j, i), map[i][j]);
            }
        }   
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Cell getCell(Position position) {
        int x = position.getX();
        int y = position.getY();
        if(x < 0 || x >= width || y < 0 || y >= height)
            return null;
        else
            return cells[y][x];
    }

    public void updateCell(Cell cell) {
        int x = cell.getX();
        int y = cell.getY();
        if(x >= 0 && x < width && y >= 0 && y < height)
            cells[y][x] = cell;
    }

    public int getFoodCount(){
        int food = 0;
        for(int i = 0; i < this.height ; i++) {
            for(int j = 0; j < this.width; j++) {
                if(cells[i][j].isFood())
                    food++;
            }
        }
        return food;
    }
}