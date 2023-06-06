package org.tricodex.view;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        /*public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 350, 400, 80);
        public Rectangle scoreLeaderboardButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 450, 400, 80);
        public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 550, 400,80);*/


        if (GamePanel.gameState == GamePanel.GameState.MENU) {
            if (mouseX >= 560 && mouseX <= 960) {
                if (mouseY >= 350 && mouseY <= 430 ) {

                    GamePanel.gameState = GamePanel.GameState.GAME;

                }
            }
            if (mouseX >= 560 && mouseX <= 960) {
                if (mouseY >= 450  && mouseY <= 530 ) {

                    GamePanel.gameState = GamePanel.GameState.LEADERBOARD;

                }
            }
            if (mouseX >= 560 && mouseX <= 960) {
                if (mouseY >= 550  && mouseY <= 630 ) {

                    System.exit(0);

                }
            }
        }

        if (GamePanel.gameState == GamePanel.GameState.LEADERBOARD) {
            if (mouseX >= 560 && mouseX <= 960) {
                if (mouseY >= 350 && mouseY <= 430) {

                    GamePanel.gameState = GamePanel.GameState.MENU;

                }
            }
        }





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
