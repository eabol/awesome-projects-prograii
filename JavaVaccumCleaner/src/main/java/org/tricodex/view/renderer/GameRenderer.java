package org.tricodex.view.renderer;
import org.tricodex.factory.GameObjectsFactory;
import org.tricodex.model.*;
import org.tricodex.utils.enums.GameState;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetPainter;
import org.tricodex.view.panels.SurfacePanel;
import org.tricodex.view.updater.GameUpdater;
import org.tricodex.view.windows.*;

import java.awt.*;
public class GameRenderer {
    private MenuWindow menuWindow;
    private LeaderboardWindow leaderboardWindow;
    private GameOverWindow gameOverWindow;
    private GameEndedWindow gameEndedWindow;
    private GamePausedWindow gamePausedWindow;
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
        this.gamePausedWindow = new GamePausedWindow(screenSettings);
    }
    public void render(Graphics g, boolean catHasSpawned, boolean hasPowerUpSpawned, GameState gameState)  {
        Graphics2D g2d = (Graphics2D) g;
        if (gameState != GameState.PAUSED) {
            clearScreen(g2d);
        }

        switch (gameState) {
            case GAME, PAUSED -> renderGameState(g2d, catHasSpawned, hasPowerUpSpawned);
            case MENU -> renderMenuState(g2d);
            case LEADERBOARD -> renderLeaderboardState(g2d);
            case GAME_ENDED -> renderGameEndedState(g2d);
            case GAME_OVER -> renderGameOverState(g2d);
        }

        if (gameState == GameState.PAUSED) {
            renderPausedState(g2d);
        }

        g2d.dispose();
    }

    private void renderGameState(Graphics2D g2d, boolean catHasSpawned, boolean hasPowerUpSpawned) {
        surfacePanel.drawSurface(g2d);
        assetPainter.paintMovingEntity(g2d, vacuum, "entities/vacuum_");
        if (catHasSpawned) assetPainter.paintMovingEntity(g2d, cat, "entities/cat_");
        if (hasPowerUpSpawned) assetPainter.paintEntity(g2d, powerUp, "entities/powerup.png");
        displayStats(g2d);
    }

    private void displayStats(Graphics2D g2d) {
        int statsPosX = screenSettings.getScreenWidth() - 223;
        int statsPosY = screenSettings.getScreenHeight() - 75;
        int lineSpacing = 20; // reduced line spacing for compactness
        int panelPadding = 10; // increased padding for readability
        int panelWidth = 200;
        int panelHeight = 300;
        int currentY = statsPosY - panelHeight + panelPadding + g2d.getFontMetrics().getAscent();

        // Draw the panel
        g2d.setColor(new Color(0, 0, 0, 120)); // slightly more opacity
        g2d.fillRect(statsPosX - panelPadding, statsPosY - panelHeight + panelPadding, panelWidth, panelHeight);

        // Draw border for panel
        g2d.setColor(new Color(169, 169, 169)); // gray color for border
        g2d.setStroke(new BasicStroke(2)); // setting border thickness
        g2d.drawRect(statsPosX - panelPadding, statsPosY - panelHeight + panelPadding, panelWidth, panelHeight);

        // Draw the text
        g2d.setColor(Color.YELLOW);
        g2d.setFont(new Font("Arial", Font.BOLD, 15)); // Bold for emphasis
        g2d.drawString("Keep Charged!", statsPosX + panelPadding, currentY + lineSpacing);
        currentY += 2 * lineSpacing; // Adding some space before next element

        currentY = drawStatsText(g2d, Color.CYAN, new Font("Arial", Font.PLAIN, 12), statsPosX, currentY, lineSpacing,
                "Score: " + gameUpdater.getGameScore(), gameUpdater.getBag(), gameUpdater.getBattery(),
                gameUpdater.getVaccumRecharge(), gameUpdater.getVaccumEmpty());

        g2d.setColor(Color.ORANGE); // Power-up in a different color
        g2d.setFont(new Font("Arial", Font.ITALIC, 12)); // Italic for differentiation
        g2d.drawString(gameUpdater.getPoweUp(), statsPosX + panelPadding, currentY + lineSpacing);

        currentY += 2 * lineSpacing; // Adding some space before next element

        currentY = drawStatsText(g2d, Color.PINK, new Font("Arial", Font.PLAIN, 12), statsPosX, currentY, lineSpacing,
                "Controls:", "- Clean: C", "- Recharge: R", "- Empty Bag: E");
    }

    private int drawStatsText(Graphics2D g2d, Color color, Font font, int startX, int startY, int lineSpacing, String... lines) {
        g2d.setColor(color);
        g2d.setFont(font);
        for (int i = 0; i < lines.length; i++) {
            g2d.drawString(lines[i], startX + 10, startY + (i+1) * lineSpacing);
        }
        return startY + lines.length * lineSpacing;
    }


    private void renderMenuState(Graphics2D g2d) {
        menuWindow.render(g2d);
    }

    private void renderLeaderboardState(Graphics2D g2d) {
        leaderboardWindow.render(g2d);
    }

    private void renderPausedState(Graphics2D g2d) {
        gamePausedWindow.render(g2d);
    }

    private void renderGameEndedState(Graphics2D g2d) {
        gameEndedWindow.render(g2d);
    }

    private void renderGameOverState(Graphics2D g2d) {
        gameOverWindow.render(g2d);
    }

    private void clearScreen(Graphics g) {
        g.clearRect(0, 0, screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
    }
}