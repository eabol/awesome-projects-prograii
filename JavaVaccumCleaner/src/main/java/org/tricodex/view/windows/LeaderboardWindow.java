package org.tricodex.view.windows;

import org.tricodex.utils.abstracts.WindowBase;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.util.HashMap;

public class LeaderboardWindow extends WindowBase {
    private Rectangle goBackButton;

    public LeaderboardWindow(ScreenSettings screenSettings) {
        super(screenSettings);
        int buttonWidth = 400;
        int buttonHeight = 80;
        int buttonX = (screenSettings.getScreenWidth() - buttonWidth) / 2;
        goBackButton = new Rectangle(buttonX, 350, buttonWidth, buttonHeight);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw title
        g.setColor(Color.black);
        g.setFont(titleFont);
        drawCenteredString(g, "Coming Soon...", new Rectangle(0, 150, screenSettings.getScreenWidth(), 0), titleFont);

        // Draw buttons
        g.setFont(buttonFont);
        drawButton(g2d, goBackButton, "Go Back", "goBackButton");
    }

    @Override
    public HashMap<String, Rectangle> getBounds() {
        HashMap<String, Rectangle> bounds = new HashMap<>();
        bounds.put("goBackButton", goBackButton);
        return bounds;
    }
}
