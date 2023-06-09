package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.enums.BoostType;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.Cleanable;

import java.awt.*;

public class Vacuum extends MovingEntity implements Cleanable {

    private int bagCapacity = 100;
    private int bagFill = 0;
    private double batteryFill= 100;
    private int batteryCapacity = 100;
    private double batteryConsumptionRate = 0.1;
    private final int MAX_RECHARGES = 5;
    private final int MAX_EMPTIES = 5;
    private int numRecharges = 0;
    private int numEmpties = 0;
    int cleaningScore = 0;
    int cleaningPoints = 10;

    public Vacuum(Point position, int speed, CellManager cellManager, int scale, int size) {
        super(position, speed, cellManager, scale, size);
        this.setPosition(this.generateRandomNonCollidablePosition());
    }

    public void move(MoveDirection direction) {
        if (batteryFill <= 0) {
            batteryFill = 0;
            return;
        }
        super.move(direction);
        batteryFill -= batteryConsumptionRate;
    }

    @Override
    public void clean() {
        if (bagFill >= bagCapacity) {
            return;
        }
        int middleX = this.position.x + entitySize / 2;
        int middleY = this.position.y + entitySize / 2;

        // If the middle position is exactly on the border, choose the cell to the right/below.
        if (middleX % cellManager.getCellSize() == 0) {
            middleX++;
        }
        if (middleY % cellManager.getCellSize() == 0) {
            middleY++;
        }

        Point middlePosition = new Point(middleX, middleY);

        if (cellManager.getCellByPoint(middlePosition).cellIsDirty()) {
            cellManager.getCellByPoint(middlePosition).clean();
            batteryFill -= batteryConsumptionRate * 3;
            bagFill++;
            cleaningScore += cleaningPoints;
        }
    }

    public void recharge() {
        if (numRecharges < MAX_RECHARGES) {
            batteryFill = 100;
            numRecharges++;
        }
    }

    public void emptyBag() {
        if (numEmpties < MAX_EMPTIES) {
            bagFill = 0;
            numEmpties++;
        }
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

    public void applyPowerUp(BoostType powerUpBoostType, int powerUpBoostAmount) {
        switch (powerUpBoostType) {
            case SPEED -> speed += powerUpBoostAmount;
            case BATTERY_LEVEL -> batteryFill = Math.min(batteryCapacity, batteryFill + powerUpBoostAmount);
            case BATTERY_MAX -> {
                batteryCapacity += powerUpBoostAmount;
                batteryFill = Math.min(batteryCapacity, batteryFill); // adjust battery level to not exceed the max
            }
            case VACUUM_CAPACITY -> bagCapacity += powerUpBoostAmount;
            default -> throw new IllegalArgumentException("Invalid boost type: " + powerUpBoostType);
        }
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
