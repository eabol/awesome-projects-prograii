package org.tricodex.view;

import org.tricodex.model.*;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;
import org.tricodex.view.assets.AssetPainter;


import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GamePanel extends JPanel implements Runnable {

    private final CellManager cellManager;
    private final KeyHandler keyHandler;
    private final Vaccum vaccum;
    private final Cat cat;
    private final PowerUp powerUp;
    private final Surface surface;
    private final DirtSensor dirtSensor;
    private final ControlPanel controlPanel;
    private final UserGuide userGuide;
    private final ScreenSettings screenSettings;
    private final SurfacePanel surfacePanel;
    private long startTime;
    private int frameCount;
    private long lastTime;
    private int fps;
    private int catSpawningTime = 0;
    private final int catSpawningTimeLimit = 600;
    private boolean catHasSpawned = false;
    private int catSpawningCooldown = 0;

    public GamePanel() {
        screenSettings = new ScreenSettings(16, 2, 32, 24, 60);
        keyHandler = new KeyHandler();
        cellManager = new CellManager(screenSettings);
        surface = new Surface(screenSettings, cellManager.getMapCellNumber());
        dirtSensor = new DirtSensor(surface);
        vaccum = new Vaccum(new Point(0, 0), surface, dirtSensor, 4, cellManager);
        cat = new Cat(new Point (600, 0), surface, 4, cellManager);
        powerUp = new PowerUp(new Point(0, 400), surface);
        userGuide = new UserGuide(surface, vaccum);
        controlPanel = new ControlPanel(userGuide, keyHandler);
        surfacePanel = new SurfacePanel(cellManager, new AssetLoader(screenSettings), screenSettings);
        startTime = System.currentTimeMillis();
        frameCount = 0;
        lastTime = System.nanoTime();
        fps = 0;
        setupPanel();
    }

    private void setupPanel() {
        setPreferredSize(screenSettings.getDimension());
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(keyHandler);
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

            updateFps();

            displayFPS();

            displayTime();

            repaint();
        }
    }

    private void update() {
        controlPanel.actionPerformed();
    }

    public void paintComponent(Graphics g) {
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
                catSpawningCooldown --;
            } else if (catHasSpawned) {
                catSpawningTime = 0;
                catHasSpawned = false;
            }


        AssetPainter.paintVaccumCleaner(g2d, vaccum, screenSettings);

        g2d.dispose();
    }


    private void updateFps() {
        long currentTime = System.nanoTime();
        frameCount++;

        // Update FPS every second (1 billion nanoseconds)
        if (currentTime - lastTime >= 1_000_000_000) {
            fps = frameCount;
            frameCount = 0;
            lastTime = currentTime;
        }
    }

    public void displayTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        System.out.println("Time: " + formattedTime);
    }

    public void displayFPS() {
        System.out.println("FPS: " + fps);

        JInternalFrame frame = new JInternalFrame("FPS: " + fps);
    }

}
