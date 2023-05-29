package org.tricodex.model;

import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.RandomMoveable;

import java.awt.*;

public class Cat extends MovingEntity implements RandomMoveable {
    private int speed = 6;

    public Cat(Point position, Surface surface) {
        super(position, surface);
    }

    @Override
    public void moveRandomly() {
        MoveDirection direction = MoveDirection.values()[(int) (Math.random() * 4)];
        move(direction, speed);
    }
}
