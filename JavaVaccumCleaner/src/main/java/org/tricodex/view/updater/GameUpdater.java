package org.tricodex.view.updater;

import org.tricodex.model.*;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.utils.enums.GameState;

public class GameUpdater {
    private final ControlPanel controlPanel;
    public final Cat cat;
    private int catSpawningTimeLimit = 600;
    private int catSpawningTime = 0;
    private boolean catHasSpawned = false;
    private int catSpawningCooldown = 0;

    public GameUpdater(ControlPanel controlPanel, Cat cat) {
        this.controlPanel = controlPanel;
        this.cat = cat;
    }

    public void updateGame(GameState gameState, boolean isPaused) {
        if (gameState == GameState.GAME && !isPaused) {
            controlPanel.actionPerformed();
            updateCatSpawn();
        }
    }

    private void updateCatSpawn() {
        if (catSpawningTime < catSpawningTimeLimit && !catHasSpawned) {
            cat.moveRandomly();
            catSpawningCooldown = 500;
            catHasSpawned = true;
            catSpawningTime++;
        } else if (catSpawningCooldown > 0) {
            cat.moveRandomly();
            catSpawningCooldown--;
        } else if (catHasSpawned) {
            catSpawningTime = 0;
            catHasSpawned = false;
        }
    }

    public boolean isCatSpawned() {
        return catHasSpawned;
    }
}
