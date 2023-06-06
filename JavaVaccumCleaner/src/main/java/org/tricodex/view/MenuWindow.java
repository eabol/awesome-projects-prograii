package org.tricodex.view;


import java.awt.*;
public class MenuWindow {

    public Rectangle playButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 350, 400, 80)
            ;
    public Rectangle scoreLeaderboardButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 450, 400, 80);
    public Rectangle quitButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 550, 400, 80);



    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);

        g.setColor(Color.black);
        g.drawString("Tricodex", GamePanel.WIDTH/2 + 600, 150);
        g.drawString("Vacuum Cleaner", GamePanel.WIDTH/2 + 450, 250);


        Font fnt1 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt1);
        g2d.draw(playButton);
        g.drawString("Play", playButton.x + 150, playButton.y + 55);
        g2d.draw(scoreLeaderboardButton);
        g.drawString("Leaderboard", scoreLeaderboardButton.x + 45, scoreLeaderboardButton.y + 55);
        g2d.draw(quitButton);
        g.drawString("Quit", quitButton.x + 150, quitButton.y + 55);




    }


}
