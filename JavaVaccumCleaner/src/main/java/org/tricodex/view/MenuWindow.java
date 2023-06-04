package org.tricodex.view;


import java.awt.*;

public class MenuWindow {

    public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 + 400, 250, 250, 50);
    public Rectangle scoreLeaderboardButton = new Rectangle(GamePanel.WIDTH / 2 + 400, 350, 250, 50);
    public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 2 + 400, 450, 250, 50);


    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt0);

        g.setColor(Color.black);
        g.drawString("Tricodex - Vacuum Cleaner", GamePanel.WIDTH/2 + 200, 150);


        Font fnt1 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt1);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x + 95, playButton.y + 35);
        g2d.draw(scoreLeaderboardButton);
        g.drawString("Leaderboard", scoreLeaderboardButton.x + 35, scoreLeaderboardButton.y + 35);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x + 95, quitButton.y + 35);
    }


}
