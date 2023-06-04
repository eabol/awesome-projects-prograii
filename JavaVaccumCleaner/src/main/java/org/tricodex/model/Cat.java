package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.abstracts.SpawnableEntity;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.Messable;
import org.tricodex.utils.interfaces.RandomMoveable;
import org.tricodex.utils.interfaces.Cleanable;

import java.awt.*;

public class Cat extends MovingEntity implements Messable, RandomMoveable {
    private int speed = 6;



    public Cat(Point position, Surface surface, int speed, CellManager cellManager) {
        super(position, surface, speed, cellManager);
    }

    @Override
    public void moveRandomly() {
        MoveDirection direction = MoveDirection.values()[(int) (Math.random() * 4)];
        move(direction);
    }

    public void foul() {
        surface.getCell(position).foul();
    }

}
