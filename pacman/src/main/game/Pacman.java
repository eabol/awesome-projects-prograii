package main.game;
public class Pacman extends GameCharacter {

    public Pacman(int x, int y) {
        super(new Position(x, y));
    }
    
    public void eatDot() {
        // Lógica para comer un punto
    }
    
    public void eatPowerPellet() {
        // Lógica para comer una Power Pellet
    }
    
    public void die() {
        // Lógica para el Pacman muerto
    }

    public Position getNextPosition(Direction direction) {
        Position nextCellPosition;
        if(direction == null)
            return new Position(this.getX(), this.getY());
        switch (direction){
            case UP:
                nextCellPosition = new Position(this.getX(), this.getY() - 1);
                break;
            case DOWN:
                nextCellPosition = new Position(this.getX(), this.getY() + 1);
                break;
            case RIGHT:
                nextCellPosition = new Position(this.getX() + 1, this.getY());
                break;
            case LEFT:
                nextCellPosition = new Position(this.getX() - 1, this.getY());
                break;
            default:
                nextCellPosition = new Position(this.getX(), this.getY());
        }
        return nextCellPosition;
    }

}