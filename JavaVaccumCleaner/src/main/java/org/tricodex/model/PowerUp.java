package org.tricodex.model;

import org.tricodex.utils.abstracts.Entity;

import java.awt.*;

public class PowerUp extends Entity {
    Point position;
    Surface surface;

    public PowerUp(Point position, Surface surface) {
        super(position);
        this.surface = surface;
    }

    public Point randomPosition() {
        this.position.x = (int) Math.random() * (surface.getWidth() + 1);
        this.position.y = (int) Math.random() * (surface.getHeight()  + 1);

        Point randomPoint = new Point(position.x, position.y);
        return randomPoint;
    }
    public void spawn() {
        Point spawningPoint = randomPosition();

       if(!surface.getCell(spawningPoint).hasFurniture()) {
           PowerUp powerUp = new PowerUp(spawningPoint, surface);
       }

    }

}
