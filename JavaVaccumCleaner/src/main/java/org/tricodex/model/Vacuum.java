package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.Cleanable;
import org.tricodex.utils.interfaces.RandomMoveable;

import java.awt.*;

public class Vacuum extends MovingEntity implements Cleanable, RandomMoveable {

    private int bagCapacity;
    private int bagContent;
    private int batteryLevel = 100;
    private DirtSensor dirtSensor;


    public Vacuum(Point position, Surface surface, DirtSensor dirtSensor, int speed, CellManager cellManager) {
        super(position, surface, speed, cellManager);
        this.dirtSensor = dirtSensor;
    }

    public void emptyBag() {
        bagContent = 0;
    }

    @Override
    public void clean() {
        surface.getCell(position).clean();
        bagContent++;
    }

    @Override
    public void moveRandomly() {
        Cell dirtiestCell = dirtSensor.getDirtiestCell();

        if (dirtiestCell == null) {
            moveRandomDirection();
        } else {
            moveToDirtiestCell(dirtiestCell);
        }
    }

    private void moveToDirtiestCell(Cell dirtiestCell) {
        int xDifference = dirtiestCell.getPosition().x - position.x;
        int yDifference = dirtiestCell.getPosition().y - position.y;

        if (xDifference > 0) {
            move(MoveDirection.RIGHT);
        } else if (xDifference < 0) {
            move(MoveDirection.LEFT);
        } else if (yDifference > 0) {
            move(MoveDirection.DOWN);
        } else if (yDifference < 0) {
            move(MoveDirection.UP);
        }
    }

    private void moveRandomDirection() {
        MoveDirection[] directions = MoveDirection.values();
        int randomIndex = (int) (Math.random() * directions.length);
        move(directions[randomIndex]);
    }

    public void move(MoveDirection direction) {
        super.move(direction);
        batteryLevel--;
    }


    public int getBagCapacity() {
        return bagCapacity;
    }

    public void setBagCapacity(int bagCapacity) {
        this.bagCapacity = bagCapacity;
    }

    public int getBagContent() {
        return bagContent;
    }

    public void setBagContent(int bagContent) {
        this.bagContent = bagContent;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
}
