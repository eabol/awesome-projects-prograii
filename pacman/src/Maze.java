public class Maze {
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width][height];
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}