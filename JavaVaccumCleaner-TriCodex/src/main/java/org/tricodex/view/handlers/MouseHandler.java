package org.tricodex.view.handlers;

import org.tricodex.utils.enums.GameState;
import org.tricodex.view.manager.GameStateManager;
import org.tricodex.view.windows.GameEndedWindow;
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MenuWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

public class MouseHandler implements MouseListener, MouseMotionListener {

    private final GameStateManager gameStateManager;
    private final MenuWindow menuWindow;
    private final LeaderboardWindow leaderboardWindow;
    private final GameEndedWindow gameEndedWindow;

    public MouseHandler(GameStateManager gameStateManager, MenuWindow menuWindow, LeaderboardWindow leaderboardWindow, GameEndedWindow gameEndedWindow) {
        this.gameStateManager = gameStateManager;
        this.menuWindow = menuWindow;
        this.leaderboardWindow = leaderboardWindow;
        this.gameEndedWindow = gameEndedWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gameStateManager.getGameState() == GameState.MENU) {
            handleMenuStateClick(e.getPoint());
        } else if (gameStateManager.getGameState() == GameState.LEADERBOARD) {
            handleLeaderboardStateClick(e.getPoint());
        } else if (gameStateManager.getGameState() == GameState.GAME_ENDED) {
            handleGameEndedStateClick(e.getPoint());
        }
    }

    private void handleMenuStateClick(Point mousePoint) {
        HashMap<String, Rectangle> bounds = menuWindow.getBounds();
        if (bounds.get("playButton").contains(mousePoint)) {
            //menuWindow.loadMap();
            gameStateManager.setGameState(GameState.GAME);
        } else if (bounds.get("scoreLeaderboardButton").contains(mousePoint)) {
            gameStateManager.setGameState(GameState.LEADERBOARD);
        } else if (bounds.get("quitButton").contains(mousePoint)) {
            System.exit(0);
        }
    }
    private void handleLeaderboardStateClick(Point mousePoint) {
        HashMap<String, Rectangle> bounds = leaderboardWindow.getBounds(); // Updated to use leaderboardWindow
        if (bounds.get("goBackButton").contains(mousePoint)) {
            gameStateManager.setGameState(GameState.MENU);
        }
    }

    private void handleGameEndedStateClick(Point mousePoint) {
        HashMap<String, Rectangle> bounds = gameEndedWindow.getBounds();
        if (bounds.get("goBackButton").contains(mousePoint)) {
            gameStateManager.setGameState(GameState.MENU);
        } else if (bounds.get("quitButton").contains(mousePoint)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point mousePoint = e.getPoint();

        if (gameStateManager.getGameState() == GameState.MENU) {
            handleMenuStateHover(mousePoint);
        } else if (gameStateManager.getGameState() == GameState.LEADERBOARD) { // New condition for leaderboard state
            handleLeaderboardStateHover(mousePoint); // New method
        } else if (gameStateManager.getGameState() == GameState.GAME_ENDED) {
            handleGameEndedStateHover(mousePoint);
        }
    }

    private void handleLeaderboardStateHover(Point mousePoint) {
        HashMap<String, Rectangle> bounds = leaderboardWindow.getBounds();

        for (Map.Entry<String, Rectangle> entry : bounds.entrySet()) {
            if (entry.getValue().contains(mousePoint)) {
                leaderboardWindow.setHoveredButton(entry.getKey());
                return;
            }
        }

        leaderboardWindow.setHoveredButton(null);
    }

    private void handleMenuStateHover(Point mousePoint) {
        HashMap<String, Rectangle> bounds = menuWindow.getBounds();

        for (Map.Entry<String, Rectangle> entry : bounds.entrySet()) {
            if (entry.getValue().contains(mousePoint)) {
                menuWindow.setHoveredButton(entry.getKey());
                return;
            }
        }

        menuWindow.setHoveredButton(null);
    }

    private void handleGameEndedStateHover(Point mousePoint) {
        HashMap<String, Rectangle> bounds = gameEndedWindow.getBounds();

        for (Map.Entry<String, Rectangle> entry : bounds.entrySet()) {
            if (entry.getValue().contains(mousePoint)) {
                gameEndedWindow.setHoveredButton(entry.getKey());
                return;
            }
        }

        gameEndedWindow.setHoveredButton(null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
