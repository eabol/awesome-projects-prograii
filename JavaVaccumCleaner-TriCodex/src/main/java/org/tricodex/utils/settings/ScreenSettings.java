package org.tricodex.utils.settings;

import java.awt.*;

public class ScreenSettings {
    private final int tileSize;
    private final int screenWidth;
    private final int screenHeight;
    private final int FPS;
    private final int maxScreenTilesWidth;
    private final int maxScreenTilesHeight;
    private final int scale;

    public ScreenSettings(int tileSize, int scale, int maxScreenTilesWidth, int maxScreenTilesHeight, int FPS) {
        this.maxScreenTilesWidth = maxScreenTilesWidth;
        this.maxScreenTilesHeight = maxScreenTilesHeight;
        this.scale = scale;

        this.tileSize = tileSize * scale;
        this.screenWidth = this.tileSize * maxScreenTilesWidth;
        this.screenHeight = this.tileSize * maxScreenTilesHeight;
        this.FPS = FPS;
    }

    public Dimension getDimension() {
        return new Dimension(screenWidth, screenHeight);
    }

    public int getFPS() {
        return FPS;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getMaxScreenTilesWidth() {
        return maxScreenTilesWidth;
    }

    public int getMaxScreenTilesHeight() {
        return maxScreenTilesHeight;
    }

    public int getScale() {
        return scale;
    }

}
