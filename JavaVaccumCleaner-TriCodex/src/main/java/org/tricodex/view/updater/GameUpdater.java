    package org.tricodex.view.updater;

    import org.tricodex.model.*;
    import org.tricodex.model.manager.CellManager;
    import org.tricodex.utils.enums.BoostType;
    import org.tricodex.utils.enums.PowerUpSoundType;
    import org.tricodex.view.services.AudioService;
    import org.tricodex.view.manager.GameStateManager;
    import org.tricodex.view.panels.ControlPanel;
    import org.tricodex.utils.enums.GameState;
    import org.tricodex.view.services.EntityService;
    import org.tricodex.view.services.ScoreService;
    import org.tricodex.view.services.StatusService;

    public class GameUpdater {
        private final ControlPanel controlPanel;
        private final Cat cat;
        private final Vacuum vacuum;
        private final CellManager cellManager;
        private int catDirtCooldown = 0;
        private final PowerUp powerUp;
        private int previousCleaningScore = 0;
        private String boostTypeReceived = "";
        private final AudioService audioService;
        private final GameStateManager gameStateManager;
        private final ScoreService scoreService;
        private final EntityService catController;
        private final EntityService powerUpController;
        private final StatusService statusDisplay;

        public GameUpdater(ControlPanel controlPanel, Cat cat, Vacuum vacuum, CellManager cellManager, PowerUp powerUp, GameStateManager gameStateManager) {
            this.controlPanel = controlPanel;
            this.cat = cat;
            this.vacuum = vacuum;
            this.powerUp = powerUp;
            this.cellManager = cellManager;
            this.gameStateManager = gameStateManager;
            this.audioService = new AudioService();
            this.scoreService = new ScoreService();
            int catDespawningTimeLimit = 400;
            int catSpawningCooldown = 500;
            int catSpawningTimeLimit = 500;
            this.catController = new EntityService(catSpawningTimeLimit, catDespawningTimeLimit, catSpawningCooldown);
            int powerUpSpawningTimeLimit = 500;
            int powerUpDespawningTimeLimit = 400;
            int powerUpSpawningCooldown = 250;
            this.powerUpController = new EntityService(powerUpSpawningTimeLimit, powerUpDespawningTimeLimit, powerUpSpawningCooldown);
            this.statusDisplay = new StatusService(vacuum);
        }

        public void updateGame(GameState gameState, boolean isPaused) {
            if (gameState == GameState.GAME && !isPaused) {
                controlPanelActionPerformed();
                updateCatState();
                updatePowerUpState();
                updateGameScore();
                audioService.update();
                checkGameOver();
            }
        }

        private void checkGameOver() {
            if (vacuum.getBatteryFill() <= 0) {
                gameStateManager.setGameState(GameState.GAME_ENDED);
                resetGame();
            }
        }

        private void resetGame() {
            vacuum.reset();
            scoreService.resetScore();
            previousCleaningScore = 0;
            catController.reset();
            powerUpController.reset();
            boostTypeReceived = "";
        }

        private void controlPanelActionPerformed() {
            controlPanel.setVacuumSound(audioService);
            controlPanel.actionPerformed();
        }

        public void updateGameScore() {
            int currentCleaningScore = vacuum.getCleaningScore();
            int cleaningScoreDifference = currentCleaningScore - previousCleaningScore;
            scoreService.addScore(cleaningScoreDifference);
            previousCleaningScore = currentCleaningScore;
        }

        private void updateCatState() {
            catController.update();
            if (catController.hasEntitySpawned()) {
                moveAndDirtyCat();
                audioService.playRandomCatSound();
            } else {
                cat.moveRandomly();
            }
        }

        private void moveAndDirtyCat() {
            if (catDirtCooldown <= 0) {
                dirtyCellUnderCat();
                int catDirtCooldownLimit = 30;
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

        private void updatePowerUpState() {
            boolean wasSpawned = powerUpController.hasEntitySpawned();
            powerUpController.update();
            boolean isSpawned = powerUpController.hasEntitySpawned();

            if (!wasSpawned && isSpawned) {
                // The powerup has just spawned
                powerUp.setNewPosition();
                audioService.playPowerUpSound(PowerUpSoundType.POWER_UP_SPAWNED);
            }

            if (isSpawned && vacuumCollidesWithPowerUp()) {
                applyBoostToVacuum();
                int powerUpPoints = 25;
                scoreService.addScore(powerUpPoints);
                boostTypeReceived = powerUp.getBoostType().getDisplayName();
                powerUpController.reset();
            }
        }


        private void applyBoostToVacuum() {
            BoostType boostType = powerUp.getBoostType();
            int boostAmount = powerUp.getBoostAmount();
            vacuum.applyPowerUp(boostType, boostAmount);
            audioService.playPowerUpSound(PowerUpSoundType.POWER_UP_COLLECTED);
        }

        private boolean vacuumCollidesWithPowerUp() {
            double dx = vacuum.getPosition().getX() - powerUp.getPosition().getX();
            double dy = vacuum.getPosition().getY() - powerUp.getPosition().getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            return distance < (vacuum.getEntitySize() + powerUp.getEntitySize()) / 2.0;
        }

        public boolean isPowerUpSpawned() {
            return powerUpController.hasEntitySpawned();
        }

        public boolean isCatSpawned() {
            return catController.hasEntitySpawned();
        }

        public String getBag() {
            return statusDisplay.getBag();
        }

        public String getBattery() {
            return statusDisplay.getBattery();
        }

        public int getGameScore() {
            return scoreService.getGameScore();
        }

        public int getHighScore() {
            return scoreService.getHighScore();
        }

        public String getVaccumRecharge() {
            return statusDisplay.getVaccumRecharge();
        }

        public String getVaccumEmpty() {
            return statusDisplay.getVaccumEmpty();
        }

        public String getPowerUp() {
            return statusDisplay.getPowerUp(boostTypeReceived);
        }
    }
