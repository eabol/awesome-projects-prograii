package org.tricodex;

import org.tricodex.factory.GameObjectsFactory;
import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.handlers.InputHandler;
import org.tricodex.view.manager.GameStateManager;
import org.tricodex.model.map.MapLoader;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.view.panels.GamePanel;
import org.tricodex.view.panels.SurfacePanel;
import org.tricodex.view.renderer.GameRenderer;
import org.tricodex.view.updater.GameUpdater;
import org.tricodex.view.windows.GameEndedWindow;
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MainWindow;
import org.tricodex.view.windows.MenuWindow;

import javax.swing.*;

public class Main {
    private static GameObjectsFactory gameObjectsFactory;
    private static CellManager cellManager;
    private static MapLoader mapLoader;
    private static ScreenSettings screenSettings;
    private static GameStateManager gameStateManager;
    private static MenuWindow menuWindow;
    private static LeaderboardWindow leaderboardWindow;
    private static GameEndedWindow gameEndedWindow;
    private static InputHandler inputHandler;
    private static GamePanel gamePanel;

    public static void main(String[] args) {
        initializeGameObjects();
        createMainWindow();
    }

    private static void initializeGameObjects() {
        gameObjectsFactory = new GameObjectsFactory();
        cellManager = gameObjectsFactory.createCellManager();
        mapLoader = gameObjectsFactory.createMapLoader(cellManager);
        System.out.println("Loading map...");
        mapLoader.loadMap("/maps/map01.txt");
        screenSettings = gameObjectsFactory.createScreenSettings();
        gameStateManager = new GameStateManager();
        menuWindow = gameObjectsFactory.createMenuWindow(mapLoader);
        leaderboardWindow = gameObjectsFactory.createLeaderboardWindow();
        gameEndedWindow = gameObjectsFactory.createGameEndedWindow();

        inputHandler = new InputHandler(gameStateManager, menuWindow, leaderboardWindow, gameEndedWindow);

        Cat cat = gameObjectsFactory.createCat(cellManager);
        Vacuum vacuum = gameObjectsFactory.createVacuum(cellManager);
        PowerUp powerUp = gameObjectsFactory.createPowerUp(cellManager);
        UserGuide userGuide = gameObjectsFactory.createUserGuide(vacuum);
        SurfacePanel surfacePanel = gameObjectsFactory.createSurfacePanel(cellManager);
        ControlPanel controlPanel = gameObjectsFactory.createControlPanel(userGuide, inputHandler.getKeyHandler(), vacuum);

        GameUpdater gameUpdater = new GameUpdater(controlPanel, cat, vacuum, cellManager, powerUp, gameStateManager);
        GameRenderer gameRenderer =  new GameRenderer(menuWindow, leaderboardWindow, gameEndedWindow, screenSettings, surfacePanel, cat, vacuum, powerUp, gameObjectsFactory.createAssetPainter(), gameUpdater);

        gamePanel = new GamePanel(gameStateManager, gameUpdater, gameRenderer, screenSettings, inputHandler);
    }

    private static void createMainWindow() {
        SwingUtilities.invokeLater(() -> {
            new MainWindow(gamePanel);
            System.out.println("Main Window created");
        });
    }
}
