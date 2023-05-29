package org.tricodex.view;

import org.tricodex.model.DirtSensor;
import org.tricodex.model.Surface;
import org.tricodex.model.UserGuide;
import org.tricodex.model.Vaccum;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.assets.AssetPainter;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final KeyHandler keyHandler;
    private final Vaccum vaccum;
    private final Surface surface;
    private final DirtSensor dirtSensor;
    private final ControlPanel controlPanel;
    private final UserGuide userGuide;
    private final ScreenSettings screenSettings;

    public GamePanel() {
        screenSettings = new ScreenSettings(16, 2, 32, 24, 60);
        keyHandler = new KeyHandler();
        surface = new Surface(screenSettings);
        dirtSensor = new DirtSensor(surface);
        vaccum = new Vaccum(new Point(100, 100), surface, dirtSensor);
        userGuide = new UserGuide(surface, vaccum);
        controlPanel = new ControlPanel(userGuide, keyHandler);

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
        AssetPainter.paintVaccumCleaner(g2d, vaccum, screenSettings);

        g2d.dispose();
    }
}
