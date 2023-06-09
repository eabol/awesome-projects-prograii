package org.tricodex.view.updater;

import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.BoostType;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.utils.enums.GameState;

public class GameUpdater {
    private final ControlPanel controlPanel;
    private final Cat cat;
    private final Vacuum vacuum;
    private final CellManager cellManager;
    private int catSpawningTime = 0;
    private int catDespawningTime = 0;
    private boolean catHasSpawned = false;
    private final int catSpawningTimeLimit = 500;
    private final int catSpawningCooldown = 500;
    private final int catDirtCooldownLimit = 30;
    private int catDirtCooldown = 0;
    private final int catDespawningTimeLimit = 400;
    private final PowerUp powerUp;
    private int powerUpSpawningTime = 0;
    private int powerUpDespawningTime = 0;
    private boolean powerUpHasSpawned = false;
    private final int powerUpSpawningTimeLimit = 500;
    private final int powerUpDespawningTimeLimit = 400;
    private final int powerUpPoints = 25;
    private int gameScore = 0;
    private int previousCleaningScore = 0;
    private String boostTypeReceived = "";

    public GameUpdater(ControlPanel controlPanel, Cat cat, Vacuum vacuum, CellManager cellManager, PowerUp powerUp) {
        this.controlPanel = controlPanel;
        this.cat = cat;
        this.vacuum = vacuum;
        this.powerUp = powerUp;
        this.cellManager = cellManager;
    }

    public void updateGame(GameState gameState, boolean isPaused) {
        if (gameState == GameState.GAME && !isPaused) {
            controlPanel.actionPerformed();
            updateCatState();
            updatePowerUpState();
            updateGameScore();
        }
    }

    public void updateGameScore() {
        int currentCleaningScore = vacuum.getCleaningScore();
        int cleaningScoreDifference = currentCleaningScore - previousCleaningScore;
        gameScore += cleaningScoreDifference;
        previousCleaningScore = currentCleaningScore;
    }

    private void updateCatState() {
        if (!catHasSpawned) {
            spawnCat();
        } else {
            moveAndDirtyCat();
            checkForCatDespawn();
        }
    }

    private void spawnCat() {
        if (catSpawningTime < catSpawningTimeLimit) {
            catSpawningTime++;
            if (catSpawningTime == catSpawningCooldown) {
                catHasSpawned = true;
                cat.moveRandomly();
            }
        }
    }

    private void moveAndDirtyCat() {
        if (catDirtCooldown <= 0) {
            dirtyCellUnderCat();
            catDirtCooldown = catDirtCooldownLimit;
        }
        catDirtCooldown--;
        cat.moveRandomly();
    }

    private void dirtyCellUnderCat() {
        cat.catFoul();
        Cell cell = cellManager.getCellByPoint(cat.getPosition());
        if (!cell.canCollide()) {
            cell.increaseDirtLevel();
        }
    }

    private void checkForCatDespawn() {
        catDespawningTime++;
        if (catDespawningTime >= catDespawningTimeLimit) {
            despawnCat();
        }
    }

    private void despawnCat() {
        catDespawningTime = 0;
        catSpawningTime = 0;
        catHasSpawned = false;
    }

    public boolean isCatSpawned() {
        return catHasSpawned;
    }

    private void updatePowerUpState() {
        if (!powerUpHasSpawned) {
            spawnPowerUp();
        } else {
            checkForPowerUpDespawn();
        }
    }

    private void spawnPowerUp() {
        if (powerUpSpawningTime < powerUpSpawningTimeLimit) {
            powerUpSpawningTime++;
            if (powerUpSpawningTime == powerUpSpawningTimeLimit) {
                powerUpHasSpawned = true;
                powerUp.setNewPosition();  // Spawn the PowerUp at a new random position
            }
        }
    }

    private void checkForPowerUpDespawn() {
        powerUpDespawningTime++;
        if (powerUpDespawningTime >= powerUpDespawningTimeLimit || vacuumCollidesWithPowerUp()) {
            if (vacuumCollidesWithPowerUp()) {
                applyBoostToVacuum();
                gameScore += powerUpPoints;
                boostTypeReceived = powerUp.getBoostType().getDisplayName();
            }
            despawnPowerUp();
        }
    }

    private void applyBoostToVacuum() {
        BoostType boostType = powerUp.getBoostType();
        int boostAmount = powerUp.getBoostAmount();
        vacuum.applyPowerUp(boostType, boostAmount);
    }

    private boolean vacuumCollidesWithPowerUp() {
        double dx = vacuum.getPosition().getX() - powerUp.getPosition().getX();
        double dy = vacuum.getPosition().getY() - powerUp.getPosition().getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance < (vacuum.getEntitySize() + powerUp.getEntitySize()) / 2.0;
    }

    private void despawnPowerUp() {
        powerUpDespawningTime = 0;
        powerUpSpawningTime = 0;
        powerUpHasSpawned = false;
    }

    public boolean isPowerUpSpawned() {
        return powerUpHasSpawned;
    }

    public String getBag() {
        return ("Bag: " + vacuum.getBagFill() + "/" + vacuum.getBagCapacity());
    }

    public String getBattery() {
        return ("Battery: " + String.format("%.2f", vacuum.getBatteryFill()) + "/" + vacuum.getBatteryCapacity());
    }


    public int getGameScore() {
        return gameScore;
    }

    public String getVaccumRecharge() {
        return ("Recharge: " + vacuum.getNumRecharges() + "/" + vacuum.getMAX_RECHARGES());
    }

    public String getVaccumEmpty() {
        return ("Empty: " + vacuum.getNumEmpties() + "/" + vacuum.getMAX_EMPTIES());
    }

    public String getPoweUp() {
        return ("PowerUp: " + boostTypeReceived);
    }
}
