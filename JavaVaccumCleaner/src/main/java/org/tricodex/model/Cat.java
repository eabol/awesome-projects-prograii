package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.abstracts.SpawnableEntity;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.utils.interfaces.Messable;
import org.tricodex.utils.interfaces.RandomMoveable;
import org.tricodex.utils.interfaces.Cleanable;

import java.util.Random;

import java.awt.*;

public class Cat extends MovingEntity implements Messable, RandomMoveable {
    private int speed = 6;


    public Cat(Point position, Surface surface, int speed, CellManager cellManager) {
        super(position, surface, speed, cellManager);
    }

    public class MoveObject {

        Point currentLocation;
        Point targetLocation;
        double speed;
        double minDistance;
        Random random = new Random();

        public MoveObject(double x, double y, double speed, double minDistance) {
            this.currentLocation = new Point((int) x, (int) y);
            this.speed = speed;
            this.minDistance = minDistance;
        }

        public void generateRandomTarget(int mapWidth, int mapHeight) {
            do {
                int x = random.nextInt(mapWidth);
                int y = random.nextInt(mapHeight);

                targetLocation = new Point(x, y);

            } while (currentLocation.distance(targetLocation) < minDistance);
        }

        public void moveToTarget() {
            double distance = currentLocation.distance(targetLocation);
            if (distance < speed) {
                currentLocation.setLocation(targetLocation);
                return;
            }

            double ratio = speed / distance;
            double newX = (1 - ratio) * currentLocation.getX() + ratio * targetLocation.getX();
            double newY = (1 - ratio) * currentLocation.getY() + ratio * targetLocation.getY();

            currentLocation.setLocation(newX, newY);
        }
    }

    @Override
    public void moveRandomly() {
        /*MoveDirection direction = MoveDirection.values()[(int) (Math.random() * 4)];
        move(direction);
*/

        MoveObject moveObject = new MoveObject(position.x, position.y, 6, 0.1);
        moveObject.generateRandomTarget(surface.getWidth(), surface.getHeight());
        moveObject.moveToTarget();
        position = moveObject.currentLocation;

    }

    public void foul() {
        surface.getCell(position).foul();
    }

}
