package org.tricodex.utils.abstracts;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;

public abstract class MovingEntity extends Entity {
    protected CellManager cellManager;
    protected int offset;
    protected int speed;
    protected int scale;

    public MovingEntity(Point position, int speed, CellManager cellManager, int scale) {
        super(position);
        this.speed = speed * scale;
        this.cellManager = cellManager;
        this.scale = scale;
        this.offset = cellManager.getCellSize() * scale / 2;
    }

    protected void move(MoveDirection direction) {
        switch (direction) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
        }
    }

    public void moveUp() {
        int newX = position.x;
        int newY = Math.max(position.y - speed, 0);

        if (!willCollide(newX, newY)) {
            position.y = newY;
        }
    }

    public void moveDown() {
        int newX = position.x;
        int newY = Math.min(position.y + speed, cellManager.getMapHeight() - offset);

        if (!willCollide(newX, newY)) {
            position.y = newY;
        }
    }

    public void moveRight() {
        int newX = Math.min(position.x + speed, cellManager.getMapWidth() - offset);
        int newY = position.y;

        if (!willCollide(newX, newY)) {
            position.x = newX;
        }
    }

    public void moveLeft() {
        int newX =  Math.max(position.x - speed, 0);
        int newY = position.y;

        if (!willCollide(newX, newY)) {
            position.x = newX;
        }
    }


    private boolean willCollide(int newX, int newY) {
        int tileSize = cellManager.getCellSize();
        int playerSize = cellManager.getCellSize();

        int topLeftX = newX / tileSize;
        int topLeftY = newY/tileSize;

        int topRightX = (newX + playerSize - 1)/tileSize;
        int topRightY = topLeftY;

        int bottomLeftX = topLeftX;
        int bottomLeftY = (newY + playerSize - 1)/tileSize;

        int bottomRightX = topRightX;
        int bottomRightY = bottomLeftY;

        System.out.println(cellManager.getCellByPoint(new Point(topLeftX, topLeftY)).canCollide() + " " + cellManager.getCellByPoint(new Point(topRightX, topRightY)).canCollide()
                + " " + cellManager.getCellByPoint(new Point(bottomLeftX, bottomLeftY)).canCollide() + " " + cellManager.getCellByPoint(new Point(bottomRightX, bottomRightY)).canCollide());

        return cellManager.getCellByPoint(new Point(topLeftX, topLeftY)).canCollide() || cellManager.getCellByPoint(new Point(topRightX, topRightY)).canCollide()
                || cellManager.getCellByPoint(new Point(bottomLeftX, bottomLeftY)).canCollide() || cellManager.getCellByPoint(new Point(bottomRightX, bottomRightY)).canCollide();
    }

}
