public class Ghost {
    private Position position;

    public Ghost(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public Position getNextPosition(Position pacmanPosition) {
        int ghostX = position.getX();
        int ghostY = position.getY();
        int pacmanX = pacmanPosition.getX();
        int pacmanY = pacmanPosition.getY();

        // Determine the direction of movement based on the current position and Pacman's position
        int nextX = ghostX;
        int nextY = ghostY;

        if (ghostX < pacmanX) {
            nextX = ghostX + 1;
        } else if (ghostX > pacmanX) {
            nextX = ghostX - 1;
        } else if (ghostY < pacmanY) {
            nextY = ghostY + 1;
        } else if (ghostY > pacmanY) {
            nextY = ghostY - 1;
        }

        return new Position(nextX, nextY);
    }

    public void move(Position pacmanPosition) {
        Position nextPosition = getNextPosition(pacmanPosition);
        position = nextPosition;
    }
}
