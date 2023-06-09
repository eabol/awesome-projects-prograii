package org.tricodex.view.handlers;

import org.tricodex.utils.enums.GameState;
import org.tricodex.utils.enums.MoveDirection;
import org.tricodex.view.manager.GameStateManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumSet;

public class KeyHandler implements KeyListener {
    private EnumSet<MoveDirection> activeDirections = EnumSet.noneOf(MoveDirection.class);
    private boolean isCleaningPressed = false;
    private boolean isRechargingPressed = false;
    private boolean isEmptyingPressed = false;
    private boolean isCleaningHandled = false;
    private boolean isRechargingHandled = false;
    private boolean isEmptyingHandled = false;
    private final GameStateManager gameStateManager;

    public KeyHandler(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
    }

    public boolean isUpPressed() {
        return activeDirections.contains(MoveDirection.UP);
    }

    public boolean isDownPressed() {
        return activeDirections.contains(MoveDirection.DOWN);
    }

    public boolean isLeftPressed() {
        return activeDirections.contains(MoveDirection.LEFT);
    }

    public boolean isRightPressed() {
        return activeDirections.contains(MoveDirection.RIGHT);
    }

    public boolean isCleaningPressed() {
        if (isCleaningPressed && !isCleaningHandled) {
            isCleaningHandled = true;
            return true;
        }
        return false;
    }

    public boolean isRechargingPressed() {
        if (isRechargingPressed && !isRechargingHandled) {
            isRechargingHandled = true;
            return true;
        }
        return false;
    }

    public boolean isEmptyingPressed() {
        if (isEmptyingPressed && !isEmptyingHandled) {
            isEmptyingHandled = true;
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> activeDirections.add(MoveDirection.UP);
            case KeyEvent.VK_DOWN -> activeDirections.add(MoveDirection.DOWN);
            case KeyEvent.VK_LEFT -> activeDirections.add(MoveDirection.LEFT);
            case KeyEvent.VK_RIGHT -> activeDirections.add(MoveDirection.RIGHT);
            case KeyEvent.VK_ENTER -> {
                if (gameStateManager.getGameState() == GameState.MENU) {
                    gameStateManager.setGameState(GameState.GAME);
                }
            }
            case KeyEvent.VK_SPACE -> {
                if (gameStateManager.getGameState() == GameState.GAME_OVER) {
                    gameStateManager.setGameState(GameState.MENU);
                }
            }
            case KeyEvent.VK_ESCAPE -> {
                if (gameStateManager.getGameState() == GameState.GAME) {
                    gameStateManager.setGameState(GameState.PAUSE);
                } else if (gameStateManager.getGameState() == GameState.PAUSE) {
                    gameStateManager.setGameState(GameState.GAME);
                }
            }
            case KeyEvent.VK_O -> {
                if (gameStateManager.getGameState() == GameState.GAME_OVER) {
                    gameStateManager.setGameState(GameState.GAME);
                }
            }
            case KeyEvent.VK_C -> isCleaningPressed = true;
            case KeyEvent.VK_R -> isRechargingPressed = true;
            case KeyEvent.VK_E -> isEmptyingPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> activeDirections.remove(MoveDirection.UP);
            case KeyEvent.VK_DOWN -> activeDirections.remove(MoveDirection.DOWN);
            case KeyEvent.VK_LEFT -> activeDirections.remove(MoveDirection.LEFT);
            case KeyEvent.VK_RIGHT -> activeDirections.remove(MoveDirection.RIGHT);
            case KeyEvent.VK_C -> {
                isCleaningPressed = false;
                isCleaningHandled = false;
            }
            case KeyEvent.VK_R -> {
                isRechargingPressed = false;
                isRechargingHandled = false;
            }
            case KeyEvent.VK_E -> {
                isEmptyingPressed = false;
                isEmptyingHandled = false;
            }
        }
    }
}
