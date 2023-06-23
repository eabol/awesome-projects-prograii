package org.tricodex.model;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.enums.BoostType;

import java.awt.*;
import java.util.Random;

public class PowerUp extends Entity {
    private CellManager cellManager;
    private BoostType boostType;
    private int boostAmount;

    public PowerUp(CellManager cellManager, int size) {
        super(size);
        this.cellManager = cellManager;
        this.position = generateRandomNonCollidablePosition();
        generateRandomBoost();
    }

    protected Point generateRandomNonCollidablePosition() {
        Random random = new Random();
        Point randomPosition;
        int entitySize = cellManager.getCellSize();  // Assuming entitySize is equal to cellSize

        do {
            int x = random.nextInt(cellManager.getMapWidth() - entitySize);
            int y = random.nextInt(cellManager.getMapHeight() - entitySize);
            randomPosition = new Point(x, y);
        } while (isColliding(randomPosition, entitySize));

        return randomPosition;
    }

    private boolean isColliding(Point position, int entitySize) {
        Point topLeft = position;
        Point topRight = new Point(position.x + entitySize, position.y);
        Point bottomLeft = new Point(position.x, position.y + entitySize);
        Point bottomRight = new Point(position.x + entitySize, position.y + entitySize);

        return cellManager.getCellByPoint(topLeft).canCollide() ||
                cellManager.getCellByPoint(topRight).canCollide() ||
                cellManager.getCellByPoint(bottomLeft).canCollide() ||
                cellManager.getCellByPoint(bottomRight).canCollide();
    }

    public void generateRandomBoost() {
        Random random = new Random();
        int boostTypeIndex = random.nextInt(BoostType.values().length);
        this.boostType = BoostType.values()[boostTypeIndex];
        if (this.boostType == BoostType.RECHARGE_MAX)
            this.boostAmount = 1;
        if (this.boostType == BoostType.EMPTY_MAX)
            this.boostAmount = 1;
        else this.boostAmount = random.nextInt(10) + 1;  // Random boost amount between 1 and 10
    }

    public BoostType getBoostType() {
        return boostType;
    }

    public int getBoostAmount() {
        return boostAmount;
    }

    public Point getPosition() {
        return position;
    }

    public void setNewPosition() {
        this.position = generateRandomNonCollidablePosition();
        generateRandomBoost();  // Generate a new boost whenever we set a new position
    }
}
