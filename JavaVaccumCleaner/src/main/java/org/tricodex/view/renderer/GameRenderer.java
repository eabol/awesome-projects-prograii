package org.tricodex.view.renderer;

import org.tricodex.factory.GameObjectsFactory;
import org.tricodex.model.*;
import org.tricodex.utils.enums.GameState;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetPainter;
import org.tricodex.view.panels.SurfacePanel;
import org.tricodex.view.updater.GameUpdater;
import org.tricodex.view.windows.GameEndedWindow;
import org.tricodex.view.windows.GameOverWindow;
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MenuWindow;

import java.awt.*;

public class GameRenderer {

    private MenuWindow menuWindow;
    private LeaderboardWindow leaderboardWindow;
    private GameOverWindow gameOverWindow;
    private GameEndedWindow gameEndedWindow;
    private final ScreenSettings screenSettings;
    private final SurfacePanel surfacePanel;
    private final Cat cat;
    private final Vacuum vacuum;
    private final PowerUp powerUp;
    private final GameObjectsFactory gameObjectsFactory;
    private final AssetPainter assetPainter;
    private final GameUpdater gameUpdater;

    public GameRenderer(MenuWindow menuWindow, LeaderboardWindow leaderboardWindow, GameObjectsFactory gameObjectsFactory,
                        ScreenSettings screenSettings, SurfacePanel surfacePanel,
                        Cat cat, Vacuum vacuum, PowerUp powerUp, AssetPainter assetPainter, GameUpdater gameUpdater) {
        this.gameObjectsFactory = gameObjectsFactory;
        this.screenSettings = screenSettings;
        this.surfacePanel = surfacePanel;
        this.cat = cat;
        this.vacuum = vacuum;
        this.powerUp = powerUp;
        this.menuWindow = menuWindow;
        this.leaderboardWindow = leaderboardWindow;
        this.assetPainter = assetPainter;
        this.gameUpdater = gameUpdater;
        this.generateWindows();

    }

    private void generateWindows() {
        this.gameOverWindow = gameObjectsFactory.createGameOverWindow();
        this.gameEndedWindow = gameObjectsFactory.createGameEndedWindow();
    }

    public void render(Graphics g, boolean catHasSpawned, boolean hasPowerUpSpawned, GameState gameState)  {
        Graphics2D g2d = (Graphics2D) g;
        switch (gameState) {
            case GAME -> paintGameState(g2d, catHasSpawned, hasPowerUpSpawned);
            case MENU -> paintMenuState(g);
            case LEADERBOARD -> paintLeaderboardState(g);
            case GAME_ENDED -> paintGameEndedState(g);
            case GAME_OVER -> paintGameOverState(g);
            default -> paintPausedState(g);
        }
    }

    private void paintGameState(Graphics2D g2d, boolean catHasSpawned, boolean hasPowerUpSpawned) {
        surfacePanel.drawSurface(g2d);
        assetPainter.paintMovingEntity(g2d, vacuum, "entities/vacuum_");
        if (catHasSpawned) {
            assetPainter.paintMovingEntity(g2d, cat, "entities/cat_");
        }
        if (hasPowerUpSpawned) {
            assetPainter.paintEntity(g2d, powerUp, "entities/powerup.png");
        }
        displayStats(g2d);
        g2d.dispose();
    }

    private void displayStats(Graphics2D g2d) {
        int statsPosX = screenSettings.getScreenWidth() - 200; // Adjust these values as necessary
        int statsPosY = screenSettings.getScreenHeight() - 70; // Adjust these values as necessary
        int lineSpacing = 25; // Adjust this value as necessary
        int panelPadding = 10; // Space between text and panel border
        int panelWidth = 200; // Width of the panel
        int panelHeight = 250; // Height of the panel

        // Draw the panel
        g2d.setColor(new Color(0, 0, 0, 100)); // Semi-transparent black
        g2d.fillRect(statsPosX - panelPadding, statsPosY - panelHeight + panelPadding, panelWidth, panelHeight);

        // Draw the text
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 15)); // Adjust these values as necessary

        // Calculate the starting position of y coordinate
        int startY = statsPosY - panelHeight + panelPadding + g2d.getFontMetrics().getAscent() + (panelHeight - (5 * lineSpacing)) / 2;

        g2d.drawString("Score: " + gameUpdater.getGameScore(), statsPosX, startY);
        g2d.drawString(gameUpdater.getBag(), statsPosX, startY + lineSpacing);
        g2d.drawString(gameUpdater.getBattery(), statsPosX, startY + 2 * lineSpacing);
        g2d.drawString(gameUpdater.getVaccumRecharge(), statsPosX, startY + 3 * lineSpacing);
        g2d.drawString(gameUpdater.getVaccumEmpty(), statsPosX, startY + 4 * lineSpacing);

        g2d.setColor(Color.RED);

        g2d.drawString(gameUpdater.getPoweUp(), statsPosX, startY + 5 * lineSpacing);

        g2d.setColor(Color.WHITE);
    }



    private void paintMenuState(Graphics g) {
        clearScreen(g);
        menuWindow.render(g);
    }

    private void paintLeaderboardState(Graphics g) {
        clearScreen(g);
        leaderboardWindow.render(g);
    }

    private void paintPausedState(Graphics g) {
        clearScreen(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("PAUSED", 650, 500);
    }

    private void paintGameEndedState(Graphics g) {
        clearScreen(g);
        gameEndedWindow.render(g);
    }

    private void paintGameOverState(Graphics g) {
        clearScreen(g);
    }

    private void paintGameStatistic(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 60));
        g.drawString("Score:", 0, 0);

    }

    private void clearScreen(Graphics g) {
        g.clearRect(0, 0, screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
    }
}
