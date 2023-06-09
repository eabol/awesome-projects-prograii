package org.tricodex.view.manager;

import org.tricodex.utils.enums.GameState;
public class GameStateManager {
    private GameState gameState = GameState.MENU;
    private boolean paused = false;

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public boolean isPaused() {
        return paused;
    }

}
