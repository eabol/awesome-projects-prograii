public abstract class GameCharacter implements GameElement {
    private int x;
    private int y;
    private Direction direction;

    public GameCharacter(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public Direction getDirection() {
        return direction;
    }
    
    public int[] move(Direction direction) {
        this.direction = direction;
        switch(direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
        int[] position = {x, y};
        return position;
    }

    public abstract void die();
}
