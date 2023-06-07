package org.tricodex.view.windows;

import org.tricodex.utils.abstracts.WindowBase;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.util.HashMap;

public class MenuWindow extends WindowBase {
    private Rectangle playButton;
    private Rectangle scoreLeaderboardButton;
    private Rectangle quitButton;

    public MenuWindow(ScreenSettings screenSettings) {
        super(screenSettings);
        int buttonWidth = 400;
        int buttonHeight = 80;
        int buttonX = (screenSettings.getScreenWidth() - buttonWidth) / 2;
        playButton = new Rectangle(buttonX, 350, buttonWidth, buttonHeight);
        scoreLeaderboardButton = new Rectangle(buttonX, 450, buttonWidth, buttonHeight);
        quitButton = new Rectangle(buttonX, 550, buttonWidth, buttonHeight);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw title
        g.setColor(Color.black);
        g.setFont(titleFont);
        drawCenteredString(g, "Tricodex Vacuum Cleaner", new Rectangle(0, 150, screenSettings.getScreenWidth(), 0), titleFont);

        // Draw buttons
        g.setFont(buttonFont);
        drawButton(g2d, playButton, "Play", "playButton");
        drawButton(g2d, scoreLeaderboardButton, "Leaderboard", "scoreLeaderboardButton");
        drawButton(g2d, quitButton, "Quit", "quitButton");
    }

    @Override
    public HashMap<String, Rectangle> getBounds() {
        HashMap<String, Rectangle> bounds = new HashMap<>();
        bounds.put("playButton", playButton);
        bounds.put("scoreLeaderboardButton", scoreLeaderboardButton);
        bounds.put("quitButton", quitButton);
        return bounds;
    }
}
