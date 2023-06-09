package org.tricodex.utils;

import org.tricodex.model.Cell;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.MoveDirection;

import java.awt.*;
import java.util.Random;

public class MoveObject {
    private Point currentLocation;
    private Point targetLocation;
    private final double speed;
    private final double minDistance;
    private final Random random = new Random();
    private final CellManager cellManager;

    public MoveObject(double x, double y, double speed, double minDistance, CellManager cellManager) {
        this.currentLocation = new Point((int) x, (int) y);
        this.speed = speed;
        this.minDistance = minDistance;
        this.cellManager = cellManager;
        generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
    }

    public void generateRandomTarget(int mapWidth, int mapHeight) {
        int counter = 0;
        do {
            int x = random.nextInt(mapWidth);
            int y = random.nextInt(mapHeight);
            targetLocation = new Point(x, y);
            counter++;
        } while (!isValidTargetLocation() && counter < 100);
    }

    private boolean isValidTargetLocation() {
        if (currentLocation.distance(targetLocation) < minDistance) {
            return false;
        }
        int x = targetLocation.x / cellManager.getCellSize();
        int y = targetLocation.y / cellManager.getCellSize();
        return !cellManager.getCellByPoint(new Point(x, y)).canCollide();
    }

    public void moveToTarget() {
        if (currentLocation.equals(targetLocation)) {
            generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
        }
        double distance = currentLocation.distance(targetLocation);
        if (distance < speed) {
            // check collision before moving
            if (!willCollide(targetLocation.x, targetLocation.y)) {
                currentLocation.setLocation(targetLocation);
            } else {
                generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
            }
            return;
        }

        double ratio = speed / distance;
        double newX = interpolate(currentLocation.getX(), targetLocation.getX(), ratio);
        double newY = interpolate(currentLocation.getY(), targetLocation.getY(), ratio);
        // check collision before moving
        if (!willCollide((int) newX, (int) newY)) {
            currentLocation.setLocation(newX, newY);
        } else {
            generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
        }
    }

    boolean willCollide(int newX, int newY) {
        int cellSize = cellManager.getCellSize();
        Point topLeft = new Point(newX, newY);
        Point topRight = new Point(newX + cellSize - 1, newY);
        Point bottomLeft = new Point(newX, newY + cellSize - 1);
        Point bottomRight = new Point(newX + cellSize - 1, newY + cellSize - 1);

        return isColliding(topLeft) || isColliding(topRight) || isColliding(bottomLeft) || isColliding(bottomRight);
    }

    boolean isColliding(Point point) {
        Cell cell = cellManager.getCellByPoint(point);
        return cell.canCollide() && cell.getBounds().contains(point);
    }

    private static double interpolate(double start, double end, double ratio) {
        return (1 - ratio) * start + ratio * end;
    }

    public Point getCurrentLocation() {
        return (Point) currentLocation.clone();
    }

    public Point getTargetLocation() {
        return (Point) targetLocation.clone();
    }

    public MoveDirection getMoveDirection() {
        int dx = targetLocation.x - currentLocation.x;
        int dy = targetLocation.y - currentLocation.y;

        if (Math.abs(dx) > Math.abs(dy)) {
            // Horizontal movement dominates
            return dx > 0 ? MoveDirection.RIGHT : MoveDirection.LEFT;
        } else if (Math.abs(dy) > Math.abs(dx)) {
            // Vertical movement dominates
            return dy > 0 ? MoveDirection.DOWN : MoveDirection.UP;
        } else {
            // If dx and dy are equal, choose a default
            // We need to ensure we don't return null or make an invalid move
            // Modify this as necessary for your use case
            return MoveDirection.DOWN;
        }
    }

}
