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
                cells[i][j] = new Cell(j, i, map[i][j]);
            }
        }   
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Cell getCell(int x, int y) {
        if(x < 0 || x >= width || y < 0 || y >= height)
            return null;
        else
            return cells[y][x];
    }
}