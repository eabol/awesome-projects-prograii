package org.tricodex.view.windows;

import org.tricodex.utils.settings.ScreenSettings;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GamePausedWindow {

    private final ScreenSettings screenSettings;

    public GamePausedWindow(ScreenSettings screenSettings) {
        this.screenSettings = screenSettings;
    }

    public void render(Graphics2D g2d) {
        g2d.setColor(new Color(0, 0, 0, 150));
        g2d.fillRect(0, 0, screenSettings.getScreenWidth(), screenSettings.getScreenHeight());
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 60));
        g2d.drawString("PAUSED", 400, 380);
    }
}
