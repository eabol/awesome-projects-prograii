package org.tricodex.view.renderer;

import org.tricodex.factory.GameObjectsFactory;
import org.tricodex.model.*;
import org.tricodex.utils.enums.GameState;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetPainter;
import org.tricodex.view.panels.SurfacePanel;
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

    public GameRenderer(MenuWindow menuWindow, LeaderboardWindow leaderboardWindow, GameObjectsFactory gameObjectsFactory,
                        ScreenSettings screenSettings, SurfacePanel surfacePanel,
                        Cat cat, Vacuum vacuum, PowerUp powerUp, AssetPainter assetPainter) {
        this.gameObjectsFactory = gameObjectsFactory;
        this.screenSettings = screenSettings;
        this.surfacePanel = surfacePanel;
        this.cat = cat;
        this.vacuum = vacuum;
        this.powerUp = powerUp;
        this.menuWindow = menuWindow;
        this.leaderboardWindow = leaderboardWindow;
        this.assetPainter = assetPainter;
        this.generateWindows();

    }

    private void generateWindows() {
        this.gameOverWindow = gameObjectsFactory.createGameOverWindow();
        this.gameEndedWindow = gameObjectsFactory.createGameEndedWindow();
    }

    public void render(Graphics g, boolean catHasSpawned, GameState gameState)  {
        Graphics2D g2d = (Graphics2D) g;
        switch (gameState) {
            case GAME -> paintGameState(g2d, catHasSpawned);
            case MENU -> paintMenuState(g);
            case LEADERBOARD -> paintLeaderboardState(g);
            case GAME_ENDED -> paintGameEndedState(g);
            case GAME_OVER -> paintGameOverState(g);
            default -> paintPausedState(g);
        }
    }

    private void paintGameState(Graphics2D g2d, boolean catHasSpawned) {
        surfacePanel.drawSurface(g2d);
        assetPainter.paintEntity(g2d, vacuum, Color.RED);
        if (catHasSpawned) {
            assetPainter.paintEntity(g2d, cat, Color.BLUE);
        }
        assetPainter.paintEntity(g2d, powerUp, Color.BLACK);
        g2d.dispose();
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
