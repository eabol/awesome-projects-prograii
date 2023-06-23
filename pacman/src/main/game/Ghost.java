package main.game;
import java.util.ArrayList;
import java.util.List;

public class Ghost extends GameCharacter {

    public Ghost(int x, int y) {
        super(new Position(x, y));
    }

    public Position chasePacman(Pacman pacman, Maze maze, List<Ghost> ghosts) {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();
        
        int ghostX = getX();
        int ghostY = getY();
        
        // Calculate the difference in positions between the ghost and pacman
        int dx = pacmanX - ghostX;
        int dy = pacmanY - ghostY;
        
        // Determine the direction to move based on the position difference
        Direction newDirection = getDirection();
        
        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) {
                newDirection = Direction.RIGHT;
            } else {
                newDirection = Direction.LEFT;
            }
        } else {
            if (dy > 0) {
                newDirection = Direction.DOWN;
            } else {
                newDirection = Direction.UP;
            }
        }
        
        // Check if the next position in the desired direction is a wall or contains another ghost
        if (isWallOrGhostInDirection(newDirection, maze, ghosts)) {
            // If a wall or another ghost is detected, try alternative directions
            List<Direction> alternativeDirections = getAlternativeDirections(newDirection, ghosts, maze);
    
            for (Direction alternativeDirection : alternativeDirections) {
                if (!isWallOrGhostInDirection(alternativeDirection, maze, ghosts)) {
                    newDirection = alternativeDirection;
                    break;
                }
            }
        }
        
        // Set the new direction and move the ghost
        setDirection(newDirection);
        return move(this.getDirection());
    }
    
    private boolean isWallOrGhostInDirection(Direction direction, Maze maze, List<Ghost> ghosts) {
        Position nextPosition = getNextPosition(direction);
        
        // Check if the next position is a wall or contains another ghost
        return isWall(nextPosition, maze) || isGhost(nextPosition, ghosts);
    }
    
    private Position getNextPosition(Direction direction) {
        int nextX = getX();
        int nextY = getY();
        
        // Calculate the next position based on the direction
        switch (direction) {
            case UP:
                nextY--;
                break;
            case DOWN:
                nextY++;
                break;
            case LEFT:
                nextX--;
                break;
            case RIGHT:
                nextX++;
                break;
        }
        
        return new Position(nextX, nextY);
    }
    
    private boolean isWall(Position position, Maze maze) {
        // Check if the position is a wall
        Cell cell = maze.getCell(position);
        return cell.isWall();
    }
    
    private boolean isGhost(Position position, List<Ghost> ghosts) {
        // Check if the position contains another ghost
        for (Ghost ghost : ghosts) {
            if (ghost != this && ghost.getX() == position.getX() && ghost.getY() == position.getY()) {
                return true;
            }
        }
        return false;
    }
    
    private List<Direction> getAlternativeDirections(Direction direction, List<Ghost> ghosts, Maze maze) {
        List<Direction> alternativeDirections = new ArrayList<>();
    
        switch (direction) {
            case UP:
            case DOWN:
                alternativeDirections.add(Direction.LEFT);
                alternativeDirections.add(Direction.RIGHT);
                break;
            case LEFT:
            case RIGHT:
                alternativeDirections.add(Direction.UP);
                alternativeDirections.add(Direction.DOWN);
                break;
        }
        
        alternativeDirections.removeIf(dir -> isWallOrGhostInDirection(dir, maze, ghosts));
    
        return alternativeDirections;
    }

    public void die(){
    }
    
}
