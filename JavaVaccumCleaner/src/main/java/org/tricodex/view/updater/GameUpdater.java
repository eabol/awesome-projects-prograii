package org.tricodex.view.updater;

import org.tricodex.model.*;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.view.panels.ControlPanel;
import org.tricodex.utils.enums.GameState;

public class GameUpdater {
    private final ControlPanel controlPanel;
    public final Cat cat;
    public final Vacuum vacuum;
    private int catSpawningTimeLimit = 600;
    private int catSpawningTime = 0;
    private boolean catHasSpawned = false;
    private int catSpawningCooldown = 0;

    public GameUpdater(ControlPanel controlPanel, Cat cat, Vacuum vacuum) {
        this.controlPanel = controlPanel;
        this.cat = cat;
        this.vacuum = vacuum;
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
            cat.catFoul();
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
