package org.tricodex.view.assets;

import org.tricodex.model.Cell;
import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.abstracts.Entity;
import org.tricodex.utils.abstracts.MovingEntity;
import org.tricodex.utils.settings.ScreenSettings;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class AssetPainter {
    private ScreenSettings screenSettings;
    private AssetLoader assetLoader;
    private final int ANIMATION_FRAME_THRESHOLD = 15;
    private final int ANIMATION_CYCLE_LENGTH = 30;
    private Map<String, BufferedImage> imageMap;

    public AssetPainter(ScreenSettings screenSettings, AssetLoader assetLoader) {
        this.screenSettings = screenSettings;
        this.assetLoader = assetLoader;
        this.imageMap = new HashMap<>();
    }

    public void paintEntity(Graphics2D g2, Entity entity, String imagePath) {
        BufferedImage image = imageMap.computeIfAbsent(imagePath, k -> assetLoader.loadImage(imagePath));
        g2.drawImage(image, entity.getPosition().x, entity.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize(), null);
    }

    public void paintMovingEntity(Graphics2D g2, MovingEntity entity, String imagePath) {
        String[] directions = {"up1", "up2", "down1", "down2", "left1", "left2", "right1", "right2"};
        for(String direction : directions) {
            String fullPath = imagePath + direction + ".png";
            imageMap.computeIfAbsent(fullPath, k -> assetLoader.loadImage(fullPath));
        }

        BufferedImage image = switch (entity.getDirection()) {
            case UP -> (entity.getPosition().y % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD) ? imageMap.get(imagePath + "up1.png") : imageMap.get(imagePath + "up2.png");
            case DOWN -> (entity.getPosition().y % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD) ? imageMap.get(imagePath + "down1.png") : imageMap.get(imagePath + "down2.png");
            case LEFT -> (entity.getPosition().x % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD) ? imageMap.get(imagePath + "left1.png") : imageMap.get(imagePath + "left2.png");
            case RIGHT -> (entity.getPosition().x % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD) ? imageMap.get(imagePath + "right1.png") : imageMap.get(imagePath + "right2.png");
        };

        g2.drawImage(image, entity.getPosition().x, entity.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize(), null);
    }

    public void paintCells(Graphics2D g2, CellManager cellManager, int mapCellNum[][]) {
        for (int col = 0; col < mapCellNum.length; col++) {
            for ( int row = 0; row < mapCellNum[col].length; row++) {
                Cell cell = cellManager.getCellByIndices(col, row);

                if (cell.getImage() != null) {
                    g2.drawImage(cell.getImage(), cell.getPosition().x, cell.getPosition().y, screenSettings.getTileSize(), screenSettings.getTileSize(), null);
                }
            }
        }
    }
}
