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
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MainWindow;
import org.tricodex.view.windows.MenuWindow;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        GameObjectsFactory gameObjectsFactory = new GameObjectsFactory();
        CellManager cellManager = gameObjectsFactory.createCellManager();
        MapLoader mapLoader = gameObjectsFactory.createMapLoader(cellManager);
        mapLoader.loadMap("/maps/map01.txt");
        ScreenSettings screenSettings = gameObjectsFactory.createScreenSettings();
        GameStateManager gameStateManager = new GameStateManager();
        MenuWindow menuWindow = gameObjectsFactory.createMenuWindow();
        LeaderboardWindow leaderboardWindow = gameObjectsFactory.createLeaderboardWindow();
        InputHandler inputHandler = new InputHandler(gameStateManager, menuWindow, leaderboardWindow);

        DirtSensor dirtSensor = gameObjectsFactory.createDirtSensor(cellManager);
        Cat cat = gameObjectsFactory.createCat(cellManager);
        System.out.println("Cat created");
        Vacuum vacuum = gameObjectsFactory.createVacuum(cellManager, dirtSensor);
        System.out.println("Vacuum created");
        PowerUp powerUp = gameObjectsFactory.createPowerUp(cellManager);
        UserGuide userGuide = gameObjectsFactory.createUserGuide(vacuum);
        SurfacePanel surfacePanel = gameObjectsFactory.createSurfacePanel(cellManager);
        ControlPanel controlPanel = gameObjectsFactory.createControlPanel(userGuide, inputHandler.getKeyHandler());

        GameUpdater gameUpdater = new GameUpdater(controlPanel, cat, vacuum);
        GameRenderer gameRenderer =  new GameRenderer(menuWindow, leaderboardWindow, gameObjectsFactory, screenSettings, surfacePanel, cat, vacuum, powerUp, gameObjectsFactory.createAssetPainter());

        GamePanel gamePanel = new GamePanel(gameStateManager, gameUpdater, gameRenderer, screenSettings, inputHandler);

        SwingUtilities.invokeLater(() -> {
            new MainWindow(gamePanel);
            System.out.println("Main Window created");
        });
    }
}