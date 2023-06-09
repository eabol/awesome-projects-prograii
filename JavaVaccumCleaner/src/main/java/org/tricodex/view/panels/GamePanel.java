package org.tricodex.view.panels;

import org.tricodex.view.audio.AudioLoader;
import org.tricodex.view.audio.AudioPlayer;
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
    private final AudioLoader audioLoader;
    private final AudioPlayer gameMusic;
    private boolean isMusicPlaying;

    public GamePanel(GameStateManager gameStateManager, GameUpdater gameUpdater, GameRenderer gameRenderer, ScreenSettings screenSettings, InputHandler inputHandler) {
        this.gameStateManager = gameStateManager;
        this.gameUpdater = gameUpdater;
        this.gameRenderer = gameRenderer;
        this.screenSettings = screenSettings;
        this.gameThread = new Thread(this);
        this.isGameRunning = false;
        this.audioLoader = new AudioLoader();
        this.gameMusic = new AudioPlayer();
        this.gameMusic.load(audioLoader.getAudioStream(6));
        this.isMusicPlaying = false;

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
        System.out.println("Game thread started");
        if(!isGameRunning) {
            gameThread.start();
            isGameRunning = true;
            System.out.println("Game thread started");
        } else {
            throw new IllegalStateException("Game is already running!");
        }
    }

    @Override
    public void run() {
        long desiredUpdateTime = 1000 / screenSettings.getFPS();

        System.out.println("Game running at " + screenSettings.getFPS() + " FPS");

        while (isGameRunning) {
            long startTime = System.nanoTime();

            if (!isMusicPlaying) {
                playGameMusic();
                isMusicPlaying = true;
            }

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
        gameRenderer.render(g, gameUpdater.isCatSpawned(), gameUpdater.isPowerUpSpawned(), gameStateManager.getGameState());
    }

    private void playGameMusic() {
        gameMusic.play();
        gameMusic.loop();
    }
}
