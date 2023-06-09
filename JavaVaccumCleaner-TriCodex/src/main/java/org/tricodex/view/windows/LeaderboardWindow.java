package org.tricodex.view.windows;

import org.tricodex.utils.abstracts.WindowBase;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.util.HashMap;

public class LeaderboardWindow extends WindowBase {
    private Rectangle goBackButton;

    public LeaderboardWindow(ScreenSettings screenSettings) {
        super(screenSettings);
        int buttonWidth = 400;
        int buttonHeight = 80;
        int buttonX = (screenSettings.getScreenWidth() - buttonWidth) / 2;
        goBackButton = new Rectangle(buttonX, 550, buttonWidth, buttonHeight);
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw gradient background
        drawGradientBackground(g2d);

        // Draw title with gradient and shadow
        g.setFont(titleFont);
        drawGradientShadowedString(g2d, "Leaderboard", 150);

        // Draw placeholder leaderboard
        g.setFont(buttonFont);
        drawCenteredString(g, "Coming Soon...", new Rectangle(0, screenSettings.getScreenHeight() / 2, screenSettings.getScreenWidth(), 0), buttonFont);

        // Draw button
        drawButton(g2d, goBackButton, "Go Back", "goBackButton");
    }

    private void drawGradientShadowedString(Graphics2D g2d, String text, int y) {
        // Create the gradient color
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(30, 136, 229), // Light Blue
                screenSettings.getScreenWidth(), y, new Color(255, 152, 0)); // Deep Orange

        // Create a layout for the title
        FontRenderContext context = g2d.getFontRenderContext();
        TextLayout layout = new TextLayout(text, titleFont, context);

        // Draw shadow
        g2d.setPaint(Color.BLACK);
        layout.draw(g2d, screenSettings.getScreenWidth() / 2 - layout.getBounds().getBounds().width / 2, y);

        // Draw the gradient title
        g2d.setPaint(gradient);
        layout.draw(g2d, screenSettings.getScreenWidth() / 2 - layout.getBounds().getBounds().width / 2, y - 5);
    }

    private void drawGradientBackground(Graphics2D g2d) {
        // Create the gradient color
        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(224, 242, 241), // Teal color lighter
                0, screenSettings.getScreenHeight(), new Color(38, 166, 154)); // Teal color darker

        // Apply the gradient color
        g2d.setPaint(gradient);

        // Draw the background
        g2d.fillRect(0, 0, screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
    }

    @Override
    public HashMap<String, Rectangle> getBounds() {
        HashMap<String, Rectangle> bounds = new HashMap<>();
        bounds.put("goBackButton", goBackButton);
        return bounds;
    }
}
