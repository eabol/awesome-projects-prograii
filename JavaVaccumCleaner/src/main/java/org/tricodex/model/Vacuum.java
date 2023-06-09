package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.enums.BoostType;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.Cleanable;

import java.awt.*;

public class Vacuum extends MovingEntity implements Cleanable {

    private static final int MAX_RECHARGES = 5;
    private static final int MAX_EMPTIES = 5;
    private static final int CLEANING_POINTS = 10;

    private int bagCapacity = 100;
    private int bagFill = 0;
    private double batteryFill = 100;
    private int batteryCapacity = 100;
    private final double batteryConsumptionRate = 0.1;

    private int numRecharges = 0;
    private int numEmpties = 0;

    private int cleaningScore = 0;

    public Vacuum(Point position, int speed, CellManager cellManager, int scale, int size) {
        super(position, speed, cellManager, scale, size);
        this.setPosition(this.generateRandomNonCollidablePosition());
    }

    public void move(MoveDirection direction) {
        if (batteryFill > 0) {
            super.move(direction);
            decreaseBattery(batteryConsumptionRate);
        }
    }

    @Override
    public void clean() {
        if (canClean()) {
            Cell cellToClean = getCellToClean();
            if (cellToClean.cellIsDirty()) {
                performCleaning(cellToClean);
            }
        }
    }

    public void recharge() {
        if (numRecharges < MAX_RECHARGES) {
            batteryFill = batteryCapacity;
            numRecharges++;
        }
    }

    public void emptyBag() {
        if (numEmpties < MAX_EMPTIES) {
            bagFill = 0;
            numEmpties++;
        }
    }

    public void applyPowerUp(BoostType powerUpBoostType, int powerUpBoostAmount) {
        switch (powerUpBoostType) {
            case SPEED -> increaseSpeed(powerUpBoostAmount);
            case BATTERY_LEVEL -> increaseBatteryLevel(powerUpBoostAmount);
            case BATTERY_MAX -> increaseBatteryMax(powerUpBoostAmount);
            case VACUUM_CAPACITY -> increaseBagCapacity(powerUpBoostAmount);
            default -> throw new IllegalArgumentException("Invalid boost type: " + powerUpBoostType);
        }
    }

    private Cell getCellToClean() {
        int middleX = this.position.x + entitySize / 2;
        int middleY = this.position.y + entitySize / 2;

        // If the middle position is exactly on the border, choose the cell to the right/below.
        if (middleX % cellManager.getCellSize() == 0) middleX++;
        if (middleY % cellManager.getCellSize() == 0) middleY++;

        Point middlePosition = new Point(middleX, middleY);
        return cellManager.getCellByPoint(middlePosition);
    }

    private boolean canClean() {
        return bagFill < bagCapacity;
    }

    private void performCleaning(Cell cellToClean) {
        cellToClean.clean();
        decreaseBattery(batteryConsumptionRate * 3);
        bagFill++;
        increaseCleaningScore();
    }

    private void decreaseBattery(double amount) {
        batteryFill -= amount;
        if (batteryFill < 0) batteryFill = 0;
    }

    private void increaseSpeed(int amount) {
        speed += amount;
    }

    private void increaseBatteryLevel(int amount) {
        batteryFill = Math.min(batteryCapacity, batteryFill + amount);
    }

    private void increaseBatteryMax(int amount) {
        batteryCapacity += amount;
        batteryFill = Math.min(batteryCapacity, batteryFill);
    }

    private void increaseBagCapacity(int amount) {
        bagCapacity += amount;
    }

    private void increaseCleaningScore() {
        cleaningScore += CLEANING_POINTS;
    }

    public int getBagCapacity() {
        return bagCapacity;
    }

    public int getBagFill() {
        return bagFill;
    }

    public double getBatteryFill() {
        return batteryFill;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getCleaningScore() {
        return cleaningScore;
    }

    public int getMAX_RECHARGES() {
        return MAX_RECHARGES;
    }

    public int getMAX_EMPTIES() {
        return MAX_EMPTIES;
    }

    public int getNumRecharges() {
        return numRecharges;
    }

    public int getNumEmpties() {
        return numEmpties;
    }
}
