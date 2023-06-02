package org.tricodex.utils.abstracts;

import org.tricodex.model.Cell;
import org.tricodex.model.Surface;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;

public abstract class MovingEntity extends Entity {

    protected Surface surface;
    private CellManager cellManager;
    protected int offset = 32;
    protected int speed;

    public MovingEntity(Point position, Surface surface, int speed, CellManager cellManager) {
        super(position);
        this.surface = surface;
        this.speed = speed;
        this.cellManager = cellManager;
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
        int newY = Math.min(position.y + speed, surface.getHeight() - offset);

        if (!willCollide(newX, newY)) {
            position.y = newY;
        }
    }

    public void moveRight() {
        int newX = Math.min(position.x + speed, surface.getWidth() - offset);
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
        int tileSize = surface.getTileSize();
        int playerSize = surface.getTileSize();

        int topLeftX = newX / tileSize;
        int topLeftY = newY/tileSize;

        int topRightX = (newX + playerSize - 1)/tileSize;
        int topRightY = topLeftY;

        int bottomLeftX = topLeftX;
        int bottomLeftY = (newY + playerSize - 1)/tileSize;

        int bottomRightX = topRightX;
        int bottomRightY = bottomLeftY;

        return cellManager.getCell(cellManager.getMapCellNumber()[topLeftX][topLeftY]).hasFurniture() || cellManager.getCell(cellManager.getMapCellNumber()[topRightX][topRightY]).hasFurniture()
                || cellManager.getCell(cellManager.getMapCellNumber()[bottomLeftX][bottomLeftY]).hasFurniture() || cellManager.getCell(cellManager.getMapCellNumber()[bottomRightX][bottomRightY]).hasFurniture();
    }

}
