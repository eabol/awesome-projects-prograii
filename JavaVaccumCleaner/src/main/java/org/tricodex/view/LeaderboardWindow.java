package org.tricodex.view;

import java.awt.*;

public class LeaderboardWindow {
    public Rectangle goBackButton = new Rectangle(GamePanel.WIDTH / 2 + 560, 350, 400, 80);
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        Font fnt0 = new Font("arial", Font.BOLD, 80);
        g.setFont(fnt0);

        g.setColor(Color.black);
        g.drawString("Coming Soon...", GamePanel.WIDTH/2 + 450, 150);

        Font fnt1 = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt1);
        g2d.draw(goBackButton);
        g.drawString("Go Back", goBackButton.x + 100, goBackButton.y + 55);


    }
}
