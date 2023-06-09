package org.tricodex.view.updater;

import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.enums.BoostType;
import org.tricodex.view.audio.AudioLoader;
import org.tricodex.view.audio.AudioPlayer;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.utils.enums.GameState;

import java.util.Random;
import java.util.function.Function;

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
    private final AudioLoader audioLoader;
    private final AudioPlayer vacuumSound;
    private final AudioPlayer powerUpSound;
    private final AudioPlayer[] catSounds;

    public GameUpdater(ControlPanel controlPanel, Cat cat, Vacuum vacuum, CellManager cellManager, PowerUp powerUp) {
        this.controlPanel = controlPanel;
        this.cat = cat;
        this.vacuum = vacuum;
        this.powerUp = powerUp;
        this.cellManager = cellManager;

        // Audio related initializations
        audioLoader = new AudioLoader();
        vacuumSound = new AudioPlayer();
        powerUpSound = new AudioPlayer();
        catSounds = new AudioPlayer[]{
                new AudioPlayer(),
                new AudioPlayer(),
                new AudioPlayer()
        };

        vacuumSound.load(audioLoader.getAudioStream(5));  // Load vacuum_cleaner.wav
        powerUpSound.load(audioLoader.getAudioStream(3)); // Load power_up_1.wav

        for (int i = 0; i < 3; i++) {
            catSounds[i].load(audioLoader.getAudioStream(i)); // Load cat_meow_1.wav, cat_meow_2.wav and cat_meow_3.wav
        }
    }

    public void updateGame(GameState gameState, boolean isPaused) {
        if (gameState == GameState.GAME && !isPaused) {
            controlPanelActionPerformed();
            updateCatState();
            updatePowerUpState();
            updateGameScore();
        }
    }

    private void controlPanelActionPerformed() {
        controlPanel.setVacuumSound(vacuumSound);
        controlPanel.actionPerformed();
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
            playCatSound();
        }
    }

    private void playCatSound() {
        // Check if any cat sound is currently playing
        for (AudioPlayer catSound : catSounds) {
            if (catSound.isPlaying()) {
                return; // If a sound is playing, do not play a new sound
            }
        }

        // Select a random cat sound
        int randomIndex = new Random().nextInt(catSounds.length);

        // Play the selected cat sound
        catSounds[randomIndex].play();
    }

    private void spawnCat() {
        if (catSpawningTime < catSpawningTimeLimit) {
            catSpawningTime++;
            if (catSpawningTime == catSpawningCooldown) {
                catHasSpawned = true;
                cat.moveRandomly();

                // Reload and play cat sound
                for (int i = 0; i < 3; i++) {
                    catSounds[i].load(audioLoader.getAudioStream(i));
                }
                playCatSound();
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

                // Reload and play power up sound
                powerUpSound.load(audioLoader.getAudioStream(3));
                powerUpSound.play();
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

        // Stop the power-up sound if it's playing
        if (powerUpSound.isPlaying()) {
            powerUpSound.stop();
        }

        // Reload and play power up sound
        powerUpSound.load(audioLoader.getAudioStream(4));
        powerUpSound.play();
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
