package org.tricodex.utils;

import org.tricodex.model.manager.CellManager;
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
        System.out.println("MoveObject constructor completed");
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
        System.out.println("generateRandomTarget method completed in MoveObject");
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
            currentLocation.setLocation(targetLocation);
            return;
        }

        double ratio = speed / distance;
        double newX = interpolate(currentLocation.getX(), targetLocation.getX(), ratio);
        double newY = interpolate(currentLocation.getY(), targetLocation.getY(), ratio);
        currentLocation.setLocation(newX, newY);
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
}
