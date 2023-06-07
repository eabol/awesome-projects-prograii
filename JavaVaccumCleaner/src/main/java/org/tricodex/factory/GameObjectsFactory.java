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
import java.io.IOException;

public class GameObjectsFactory {

    public MenuWindow createMenuWindow() {
        return new MenuWindow(this.createScreenSettings());
    }

    public LeaderboardWindow createLeaderboardWindow() {
        return new LeaderboardWindow(this.createScreenSettings());
    }

    public GameOverWindow createGameOverWindow() {
        return new GameOverWindow();
    }

    public GameEndedWindow createGameEndedWindow() {
        return new GameEndedWindow();
    }

    public ScreenSettings createScreenSettings() {
        return new ScreenSettings(16, 3, 32, 24, 60);
    }

    public SurfacePanel createSurfacePanel(CellManager cellManager) {
        return new SurfacePanel(cellManager, createAssetPainter());
    }

    public Cat createCat(CellManager cellManager) {
        ScreenSettings screenSettings = this.createScreenSettings();
        return new Cat(new Point(600, 0), 4, cellManager, screenSettings.getScale());
    }

    public Vacuum createVacuum(DirtSensor dirtSensor, CellManager cellManager) {
        ScreenSettings screenSettings = this.createScreenSettings();
        return new Vacuum(new Point(0, 0), dirtSensor, 4, cellManager, screenSettings.getScale());
    }

    public PowerUp createPowerUp(CellManager cellManager) {
        return new PowerUp(new Point(0, 400), cellManager);
    }

    public CellManager createCellManager() throws IOException {
        return new CellManager(this.createScreenSettings(), this.createCellFactory());
    }

    public MapLoader createMapLoader(CellManager cellManager) {
        return new MapLoader(this.createScreenSettings(), cellManager);
    }

    public AssetPainter createAssetPainter() {
        return new AssetPainter(this.createScreenSettings());
    }

    public CellFactory createCellFactory() {
        return new CellFactory(this.createAssetLoader());
    }

    public AssetLoader createAssetLoader() {
        return new AssetLoader();
    }

    public UserGuide createUserGuide(Vacuum vaccum) {
        return new UserGuide(vaccum);
    }

    public ControlPanel createControlPanel(UserGuide userGuide, KeyHandler keyHandler) {
        return new ControlPanel(userGuide, keyHandler);
    }

    public DirtSensor createDirtSensor(CellManager cellManager) {
        return new DirtSensor(cellManager);
    }
}
