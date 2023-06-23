package org.tricodex.view.handlers;

import org.tricodex.view.manager.GameStateManager;
import org.tricodex.view.windows.GameEndedWindow;
import org.tricodex.view.windows.LeaderboardWindow;
import org.tricodex.view.windows.MenuWindow;

public class InputHandler {
    private final KeyHandler keyHandler;
    private final MouseHandler mouseHandler;

    public InputHandler(GameStateManager gameStateManager, MenuWindow menuWindow, LeaderboardWindow leaderboardWindow, GameEndedWindow gameEndedWindow) {
        this.keyHandler = new KeyHandler(gameStateManager);
        this.mouseHandler = new MouseHandler(gameStateManager, menuWindow, leaderboardWindow, gameEndedWindow);
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public MouseHandler getMouseHandler() {
        return mouseHandler;
    }
}
