package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.MoveObject;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.interfaces.RandomMoveable;

import java.awt.*;

public class Cat extends MovingEntity implements RandomMoveable {
    private MoveObject moveObject;

    public Cat(Point position, int speed, CellManager cellManager, int scale, int size) {
        super(position, speed, cellManager, scale, size);
        this.setPosition(this.generateRandomNonCollidablePosition());
        this.moveObject = new MoveObject(position.x, position.y, speed, 5, cellManager);
        moveObject.generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
    }

    @Override
    public void moveRandomly() {
        if (moveObject.getCurrentLocation().distance(moveObject.getTargetLocation()) < speed) {
            moveObject.generateRandomTarget(cellManager.getMapWidth(), cellManager.getMapHeight());
        }
        moveObject.moveToTarget();
        this.direction = moveObject.getMoveDirection();
        position = new Point(moveObject.getCurrentLocation());
    }

    public void catFoul(){
        cellManager.getCellByPoint(position).increaseDirtLevel();
    }

    public void setMoveObject(MoveObject moveObject) {
        this.moveObject = moveObject;
    }
}
