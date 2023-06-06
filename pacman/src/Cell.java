public class Cell {
    private int x;
    private int y;
    private boolean isWall;
    private boolean hasDot;

    public Cell(int x, int y, int value) {
        this.x = x;
        this.y = y;
        if(value == 1) {
            this.isWall = true;
        } else if (value == 2) {
            this.hasDot = true;
        }
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public boolean isWall() {
        return isWall;
    }
    
    public boolean hasDot() {
        return hasDot;
    }
}
