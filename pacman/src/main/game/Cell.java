package main.game;
public class Cell implements GameElement {
    private Position position;
    private CellType type;

    public Cell(Position position, int value) {
        this.position = position;
        switch (value) {
            case 0:
                type = CellType.EMPTY;
                break;
            case 1:
                type = CellType.WALL;
                break;
            case 2:
                type = CellType.FOOD;
                break;
            case 3:
                type = CellType.POWER;
                break;
        }
    }

    public Cell(Position position, CellType type) {
        this.position = position;
        this.type = type;
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

    public boolean isWall() {
        return type == CellType.WALL;
    }

    public boolean isFood() {
        return type == CellType.FOOD;
    }

    public boolean isPower() {
        return type == CellType.POWER;
    }

    public boolean isEmpty() {
        return type == CellType.EMPTY;
    }
}
