package org.tricodex.view;

import org.tricodex.utils.enums.MoveDirection;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.EnumSet;

public class KeyHandler implements KeyListener {
    private EnumSet<MoveDirection> activeDirections = EnumSet.noneOf(MoveDirection.class);

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

    /**
     * An empty implementation of keyTyped, as it is not needed for this class.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Handles keyPressed events by adding the corresponding direction to the activeDirections set.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> activeDirections.add(MoveDirection.UP);
            case KeyEvent.VK_DOWN -> activeDirections.add(MoveDirection.DOWN);
            case KeyEvent.VK_LEFT -> activeDirections.add(MoveDirection.LEFT);
            case KeyEvent.VK_RIGHT -> activeDirections.add(MoveDirection.RIGHT);
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && GamePanel.gameState == GamePanel.GameState.GAME) {
            if (GamePanel.paused) {
                GamePanel.paused = false;
            } else {
                GamePanel.paused = true;
            }
        }
    }

    /**
     * Handles keyReleased events by removing the corresponding direction from the activeDirections set.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> activeDirections.remove(MoveDirection.UP);
            case KeyEvent.VK_DOWN -> activeDirections.remove(MoveDirection.DOWN);
            case KeyEvent.VK_LEFT -> activeDirections.remove(MoveDirection.LEFT);
            case KeyEvent.VK_RIGHT -> activeDirections.remove(MoveDirection.RIGHT);
        }
    }
}
