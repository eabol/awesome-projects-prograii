package game;
public abstract class GameCharacter implements GameElement {
    private Position position;
    private Direction direction;

    public GameCharacter(Position position) {
        this.position = position;
    }
    
    public int getX() {
        return position.getX();
    }
    
    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public Position move(Direction direction) {
        this.direction = direction;
        Position previousPosition = new Position(position.getX(), position.getY());
        switch(direction) {
            case UP:
                position.setY(position.getY() - 1);
                break;
            case DOWN:
                position.setY(position.getY() + 1);
                break;
            case LEFT:
                position.setX(position.getX() - 1);
                break;
            case RIGHT:
                position.setX(position.getX() + 1);
                break;
        }
        return previousPosition;
    }

    public abstract void die();
}
