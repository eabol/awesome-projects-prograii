package org.tricodex.view.panels;

import org.tricodex.view.handlers.InputHandler;
import org.tricodex.view.handlers.KeyHandler;
import org.tricodex.view.handlers.MouseHandler;
import org.tricodex.view.manager.GameStateManager;
import org.tricodex.view.renderer.GameRenderer;
import org.tricodex.utils.settings.ScreenSettings;
import org.tricodex.view.updater.GameUpdater;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    private final GameStateManager gameStateManager;
    private final GameUpdater gameUpdater;
    private final GameRenderer gameRenderer;
    private final ScreenSettings screenSettings;
    private final Thread gameThread;
    private boolean isGameRunning;

    public GamePanel(GameStateManager gameStateManager, GameUpdater gameUpdater, GameRenderer gameRenderer, ScreenSettings screenSettings, InputHandler inputHandler) {
        this.gameStateManager = gameStateManager;
        this.gameUpdater = gameUpdater;
        this.gameRenderer = gameRenderer;
        this.screenSettings = screenSettings;
        this.gameThread = new Thread(this);
        this.isGameRunning = false;

        setupPanel(inputHandler.getKeyHandler(), inputHandler.getMouseHandler());
    }

    private void setupPanel(KeyHandler keyHandler, MouseHandler mouseHandler) {
        setPreferredSize(screenSettings.getDimension());
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setFocusable(true);
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void startGameThread() {
        if(!isGameRunning) {
            gameThread.start();
            isGameRunning = true;
        } else {
            throw new IllegalStateException("Game is already running!");
        }
    }

    @Override
    public void run() {
        long desiredUpdateTime = 1000 / screenSettings.getFPS();

        while (isGameRunning) {
            long startTime = System.nanoTime();

            gameUpdater.updateGame(gameStateManager.getGameState(), gameStateManager.isPaused());

            SwingUtilities.invokeLater(this::repaint);

            long timeTaken = (System.nanoTime() - startTime) / 1_000_000; // Convert to milliseconds
            long remainingTime = desiredUpdateTime - timeTaken;

            if (remainingTime > 0) {
                try {
                    Thread.sleep(remainingTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    stopGame("Game thread was interrupted", e);
                }
            }
        }
    }

    private void stopGame(String message, Exception e) {
        isGameRunning = false;
        e.printStackTrace();
        System.err.println(message);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        gameRenderer.render(g, gameUpdater.isCatSpawned(), gameStateManager.getGameState());
    }
}
