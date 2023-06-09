package org.tricodex.factory;

import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;
import org.tricodex.view.assets.AssetPainter;
import org.tricodex.view.handlers.KeyHandler;
import org.tricodex.model.map.MapLoader;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.view.panels.SurfacePanel;
import org.tricodex.view.windows.GameEndedWindow;
import org.tricodex.view.windows.GameOverWindow;
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MenuWindow;

import java.awt.*;

public class GameObjectsFactory {

    private ScreenSettings screenSettings;
    private AssetLoader assetLoader;

    public GameObjectsFactory() {
        this.screenSettings = new ScreenSettings(16, 2, 32, 24, 60);
        this.assetLoader = new AssetLoader();
    }

    public ScreenSettings createScreenSettings() {
        return screenSettings;
    }

    public MenuWindow createMenuWindow(MapLoader mapLoader) {
        return new MenuWindow(screenSettings, mapLoader);
    }

    public LeaderboardWindow createLeaderboardWindow() {
        return new LeaderboardWindow(screenSettings);
    }

    public GameOverWindow createGameOverWindow() {
        return new GameOverWindow();
    }

    public GameEndedWindow createGameEndedWindow() {
        return new GameEndedWindow();
    }

    public SurfacePanel createSurfacePanel(CellManager cellManager) {
        return new SurfacePanel(cellManager, createAssetPainter());
    }

    public Cat createCat(CellManager cellManager) {
        return new Cat(new Point(650, 200), 4, cellManager, screenSettings.getScale(), cellManager.getCellSize());
    }

    public Vacuum createVacuum(CellManager cellManager) {
        return new Vacuum(new Point(150, 150), 4, cellManager, screenSettings.getScale(), cellManager.getCellSize());
    }

    public PowerUp createPowerUp(CellManager cellManager) {
        return new PowerUp(cellManager, cellManager.getCellSize());
    }

    public CellManager createCellManager()  {
        return new CellManager(screenSettings, this.createCellFactory());
    }

    public MapLoader createMapLoader(CellManager cellManager) {
        return new MapLoader(screenSettings, cellManager);
    }

    public AssetPainter createAssetPainter() {
        return new AssetPainter(screenSettings, assetLoader);
    }

    public CellFactory createCellFactory() {
        return new CellFactory(assetLoader, screenSettings);
    }

    public UserGuide createUserGuide(Vacuum vaccum) {
        return new UserGuide(vaccum);
    }

    public ControlPanel createControlPanel(UserGuide userGuide, KeyHandler keyHandler, Vacuum vacuum) {
        return new ControlPanel(userGuide, keyHandler, vacuum);
    }
}
