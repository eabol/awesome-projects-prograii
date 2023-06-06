package org.tricodex.view;

import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;
import org.tricodex.view.assets.AssetPainter;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable {

    public static GameState gameState = GameState.MENU;
    public static boolean paused = false;
    private final CellManager cellManager;
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;
    private final Vacuum vacuum;
    private final Cat cat;
    private final PowerUp powerUp;
    private final Surface surface;
    private final DirtSensor dirtSensor;
    private final ControlPanel controlPanel;
    private final UserGuide userGuide;
    private final ScreenSettings screenSettings;
    private final SurfacePanel surfacePanel;
    private final int catSpawningTimeLimit = 600;
    private int catSpawningTime = 0;
    private boolean catHasSpawned = false;
    private int catSpawningCooldown = 0;
    private MenuWindow menuWindow;
    private LeaderboardWindow leaderboardWindow;
    private GameEndedWindow gameEndedWindow;
    private GameOverWindow gameOverWindow;

    public GamePanel() {
        menuWindow = new MenuWindow();
        leaderboardWindow = new LeaderboardWindow();
        gameOverWindow = new GameOverWindow();
        gameEndedWindow = new GameEndedWindow();
        screenSettings = new ScreenSettings(16,3 , 32, 24, 60);
        keyHandler = new KeyHandler();
        mouseHandler = new MouseHandler();
        cellManager = new CellManager(screenSettings);
        surface = new Surface(screenSettings, cellManager.getMapCellNumber());
        dirtSensor = new DirtSensor(surface);
        vacuum = new Vacuum(new Point(0, 0), surface, dirtSensor, 4, cellManager);
        cat = new Cat(new Point(600, 0), surface, 4, cellManager);
        powerUp = new PowerUp(new Point(0, 400), surface);
        userGuide = new UserGuide(surface, vacuum);
        controlPanel = new ControlPanel(userGuide, keyHandler);
        surfacePanel = new SurfacePanel(cellManager, new AssetLoader(screenSettings), screenSettings);

        setupPanel();
    }

    private void setupPanel() {
        setPreferredSize(screenSettings.getDimension());
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
    }

    public void startGameThread() {

        Thread gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {


        while (Thread.currentThread().isAlive()) {
            try {
                Thread.sleep(1000 / screenSettings.getFPS());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            update();

            repaint();


        }
    }

    private void update() {

        if (gameState == GameState.GAME) {

            if (!paused) {

                controlPanel.actionPerformed();
            }
        }

    }

    public void paintComponent(Graphics g) {

        if (gameState == GameState.GAME) {

            if (!paused) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                surfacePanel.drawSurface(g2d);

                AssetPainter.paintPowerUp(g2d, powerUp, screenSettings);


                if (catSpawningTime < catSpawningTimeLimit) {

                    AssetPainter.paintCat(g2d, cat, screenSettings);
                    cat.moveRandomly();
                    catSpawningCooldown = 500;
                    catHasSpawned = true;
                    catSpawningTime++;
                } else if (catSpawningCooldown > 0) {
                    catSpawningCooldown--;
                } else if (catHasSpawned) {
                    catSpawningTime = 0;
                    catHasSpawned = false;
                }


                AssetPainter.paintVaccumCleaner(g2d, vacuum, screenSettings);

                g2d.dispose();

            }


        } else if (gameState == GameState.MENU) {
            g.clearRect(0, 0, getWidth(), getHeight());
            menuWindow.render(g);

        } else if (gameState == GameState.LEADERBOARD) {
            g.clearRect(0, 0, getWidth(), getHeight());
            leaderboardWindow.render(g);

        } else if (paused) {

            g.clearRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("PAUSED", 300, 300);


        } else if (gameState == GameState.GAME_ENDED) {
            g.clearRect(0, 0, getWidth(), getHeight());
            gameEndedWindow.render(g);

        } else if (gameState == GameState.GAME_OVER) {
            g.clearRect(0, 0, getWidth(), getHeight());
            gameOverWindow.render(g);

        }


    /*public void catCellFoul() {

        if (surface.getCell(cat.getPosition()).getDirtLevel() == DirtLevel.CLEAN) {
            surface.getCell(cat.getPosition()).foul();

        } else if (surface.getCell(cat.getPosition()).getDirtLevel() == DirtLevel.DIRTY) {
            surface.getCell(cat.getPosition()).foul();
        } else if (surface.getCell(cat.getPosition()).getDirtLevel() == DirtLevel.VERY_DIRTY) {
            surface.getCell(cat.getPosition()).clean();
        } else if (surface.getCell(cat.getPosition()).getDirtLevel() == DirtLevel.FILTHY) {
            surface.getCell(cat.getPosition()).clean();
        }
    }*/

    }

    public void gameStatistics() {


    }

    public static enum GameState {
        MENU,
        GAME,
        LEADERBOARD,
        PAUSE,
        GAME_ENDED,
        GAME_OVER
    }
}

