package org.tricodex.view;

import org.tricodex.model.DirtSensor;
import org.tricodex.model.Surface;
import org.tricodex.model.UserGuide;
import org.tricodex.model.Vaccum;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetLoader;
import org.tricodex.view.assets.AssetPainter;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final CellManager cellManager;
    private final KeyHandler keyHandler;
    private final Vaccum vaccum;
    private final Surface surface;
    private final DirtSensor dirtSensor;
    private final ControlPanel controlPanel;
    private final UserGuide userGuide;
    private final ScreenSettings screenSettings;

    private final SurfacePanel surfacePanel;

    public GamePanel() {
        screenSettings = new ScreenSettings(16, 2, 32, 24, 60);
        keyHandler = new KeyHandler();
        cellManager = new CellManager(screenSettings);
        surface = new Surface(screenSettings, cellManager.getMapCellNumber());
        dirtSensor = new DirtSensor(surface);
        vaccum = new Vaccum(new Point(0, 0), surface, dirtSensor, 4, cellManager);
        userGuide = new UserGuide(surface, vaccum);
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
        controlPanel.actionPerformed();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;


        surfacePanel.drawSurface(g2d);
        AssetPainter.paintVaccumCleaner(g2d, vaccum, screenSettings);

        g2d.dispose();
    }
}
