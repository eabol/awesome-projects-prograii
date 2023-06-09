package org.tricodex.utils.abstracts;

import org.tricodex.model.Cell;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;
import java.util.Random;

public abstract class MovingEntity extends Entity {

    protected CellManager cellManager;
    protected int offset;
    protected int speed;
    protected int scale;
    protected MoveDirection direction = MoveDirection.DOWN;

    public MovingEntity(Point position, int speed, CellManager cellManager, int scale, int size) {
        super(position, size);
        this.speed = speed;
        this.cellManager = cellManager;
        this.scale = scale;
        this.offset = cellManager.getCellSize() * scale / 2 + 5;
    }

    protected void move(MoveDirection direction) {
        this.direction = direction == null ? this.direction : direction;
        switch (direction) {
            case UP -> move(0, -speed);
            case DOWN -> move(0, speed);
            case LEFT -> move(-speed, 0);
            case RIGHT -> move(speed, 0);
        }
    }

    private void move(int dx, int dy) {
        int newX = position.x + dx;
        int newY = position.y + dy;
        if (!willCollide(newX, newY)) {
            newX = Math.max(Math.min(newX, cellManager.getMapWidth() - offset), 0);
            newY = Math.max(Math.min(newY, cellManager.getMapHeight() - offset), 0);
            position.setLocation(newX, newY);
        }
    }

    private boolean willCollide(int newX, int newY) {
        int cellSize = cellManager.getCellSize();
        Point topLeft = new Point(newX, newY);
        Point topRight = new Point(newX + cellSize - 1, newY);
        Point bottomLeft = new Point(newX, newY + cellSize - 1);
        Point bottomRight = new Point(newX + cellSize - 1, newY + cellSize - 1);

        return isColliding(topLeft) || isColliding(topRight) || isColliding(bottomLeft) || isColliding(bottomRight);
    }

    private boolean isColliding(Point point) {
        Cell cell = cellManager.getCellByPoint(point);
        if(cell == null) {
            return false;
        }
        return cell.canCollide() && cell.getBounds().contains(point);
    }

    protected Point generateRandomNonCollidablePosition() {
        Random random = new Random();
        Point randomPosition;
        int entitySize = getEntitySize();  // Assuming entitySize is equal to cellSize

        do {
            int x = random.nextInt(cellManager.getMapWidth() - entitySize);
            int y = random.nextInt(cellManager.getMapHeight() - entitySize);
            randomPosition = new Point(x, y);
        } while (isEntityColliding(randomPosition, entitySize));

        return randomPosition;
    }

    private boolean isEntityColliding(Point topLeft, int entitySize) {
        Point topRight = new Point(topLeft.x + entitySize - 1, topLeft.y);
        Point bottomLeft = new Point(topLeft.x, topLeft.y + entitySize - 1);
        Point bottomRight = new Point(topLeft.x + entitySize - 1, topLeft.y + entitySize - 1);

        return isColliding(topLeft) || isColliding(topRight) || isColliding(bottomLeft) || isColliding(bottomRight);
    }


    public MoveDirection getDirection() {
        return direction;
    }
}
