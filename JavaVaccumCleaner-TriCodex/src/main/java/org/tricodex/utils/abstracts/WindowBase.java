package org.tricodex.utils.abstracts;

import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.util.HashMap;

public abstract class WindowBase {
    protected final ScreenSettings screenSettings;
    protected final Font titleFont = new Font("Arial", Font.BOLD, 80);
    protected final Font buttonFont = new Font("Arial", Font.BOLD, 50);

    protected final Color buttonColor = new Color(100, 100, 100);
    protected final Color hoverColor = new Color(130, 130, 130);

    protected String hoveredButton = null;

    public WindowBase(ScreenSettings screenSettings) {
        this.screenSettings = screenSettings;
    }

    protected void drawCenteredString(Graphics g, String text, Rectangle rect, Font font) {
        FontMetrics metrics = g.getFontMetrics(font);
        int x = rect.x + (rect.width - metrics.stringWidth(text)) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(text, x, y);
    }

    protected void drawButton(Graphics2D g, Rectangle button, String text, String buttonName) {
        if (buttonName.equals(hoveredButton)) {
            g.setColor(hoverColor);
        } else {
            g.setColor(buttonColor);
        }
        g.fill(button);
        g.setColor(Color.white);
        g.draw(button);
        drawCenteredString(g, text, button, buttonFont);
    }

    public abstract HashMap<String, Rectangle> getBounds();

    public void setHoveredButton(String button) {
        hoveredButton = button;
    }
}
