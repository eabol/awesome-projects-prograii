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

    public MenuWindow createMenuWindow() {
        return new MenuWindow(this.createScreenSettings());
    }

    public LeaderboardWindow createLeaderboardWindow() {
        System.out.println("Creating LeaderboardWindow");
        return new LeaderboardWindow(this.createScreenSettings());
    }

    public GameOverWindow createGameOverWindow() {
        System.out.println("Creating GameOverWindow");
        return new GameOverWindow();
    }

    public GameEndedWindow createGameEndedWindow() {
        System.out.println("Creating GameEndedWindow");
        return new GameEndedWindow();
    }

    public ScreenSettings createScreenSettings() {
        return new ScreenSettings(16, 2, 32, 24, 60);
    }

    public SurfacePanel createSurfacePanel(CellManager cellManager) {
        System.out.println("Creating SurfacePanel");
        return new SurfacePanel(cellManager, createAssetPainter());
    }

    public Cat createCat(CellManager cellManager) {
        ScreenSettings screenSettings = this.createScreenSettings();
        return new Cat(new Point(650, 200), 4, cellManager, screenSettings.getScale(), cellManager.getCellSize());
    }

    public Vacuum createVacuum(CellManager cellManager) {
        ScreenSettings screenSettings = this.createScreenSettings();
        return new Vacuum(new Point(150, 150), 4, cellManager, screenSettings.getScale(), cellManager.getCellSize());
    }

    public PowerUp createPowerUp(CellManager cellManager) {
        System.out.println("Creating PowerUp");
        return new PowerUp(cellManager, cellManager.getCellSize());
    }

    public CellManager createCellManager()  {
        System.out.println("Creating CellManager");
        return new CellManager(this.createScreenSettings(), this.createCellFactory());
    }

    public MapLoader createMapLoader(CellManager cellManager) {
        System.out.println("Creating MapLoader");
        return new MapLoader(this.createScreenSettings(), cellManager);
    }

    public AssetPainter createAssetPainter() {
        System.out.println("Creating AssetPainter");
        return new AssetPainter(this.createScreenSettings(), this.createAssetLoader());
    }

    public CellFactory createCellFactory() {
        System.out.println("Creating CellFactory");
        return new CellFactory(this.createAssetLoader(), this.createScreenSettings());
    }

    public AssetLoader createAssetLoader() {
        System.out.println("Creating AssetLoader");
        return new AssetLoader();
    }

    public UserGuide createUserGuide(Vacuum vaccum) {
        System.out.println("Creating UserGuide");
        return new UserGuide(vaccum);
    }

    public ControlPanel createControlPanel(UserGuide userGuide, KeyHandler keyHandler, Vacuum vacuum) {
        System.out.println("Creating ControlPanel");
        return new ControlPanel(userGuide, keyHandler, vacuum);
    }
}
