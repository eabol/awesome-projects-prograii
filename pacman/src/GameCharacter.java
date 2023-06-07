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
    
    public void move() {
        // Lógica para mover el personaje
    }
    
    public abstract void draw();

    public abstract void die();
}
