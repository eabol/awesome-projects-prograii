package org.tricodex.view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (GamePanel.gameState == GamePanel.GameState.MENU) {
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 250 && mouseY <= 300) {

                    GamePanel.gameState = GamePanel.GameState.GAME;

                }
            }
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 350 && mouseY <= 400) {

                    GamePanel.gameState = GamePanel.GameState.LEADERBOARD;

                }
            }
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 450 && mouseY <= 600) {

                    System.exit(0);

                }
            }
        }

        if (GamePanel.gameState == GamePanel.GameState.LEADERBOARD) {
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 250 && mouseY <= 300) {

                    GamePanel.gameState = GamePanel.GameState.MENU;

                }
            }
        }

        /*if (GamePanel.gameState == GamePanel.GameState.PAUSE) {
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 250 && mouseY <= 300) {


                }
            }
        }
        if (GamePanel.gameState == GamePanel.GameState.GAME_OVER) {
            if (mouseX >= 400 && mouseX <= 650) {
                if (mouseY >= 250 && mouseY <= 300) {


                }
            }
        }*/


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


    public void mouseExited(MouseEvent e) {


    }
}
