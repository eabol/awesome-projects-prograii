package view.assets;

import core.character.Player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImagePainter {

    private Map<String, BufferedImage> imageMap;
    private final int ANIMATION_FRAME_THRESHOLD = 15;
    private final int ANIMATION_CYCLE_LENGTH = 30;
    private ImageLoader imageLoader;

    public ImagePainter(ImageLoader imageLoader) {
        this.imageMap = new HashMap<>();
        this.imageLoader = imageLoader;
    }

    public void paintPlayer(Graphics2D g2, Player player, int characterWidth, int characterHeight) {
        String[] directions = { "up1", "up2", "down1", "down2", "left1", "left2", "right1", "right2" };
        String imagePath;

        switch (player.getCurrentTransport()) {
            case FOOT -> imagePath = "player/foot_";
            case BOAT -> imagePath = "player/boat_";
            case HORSE -> imagePath = "player/horse_";
            case CARPET -> imagePath = "player/carpet_";
            default -> throw new IllegalStateException("Unexpected value: " + player.getCurrentTransport());
        }

        for (String direction : directions) {
            String fullPath = imagePath + direction + ".png";
            imageMap.computeIfAbsent(fullPath, k -> imageLoader.loadImage(fullPath));
        }

        BufferedImage image = switch (player.getDirection()) {
            case UP -> (player.getPosition().y % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD)
                    ? imageMap.get(imagePath + "up1.png")
                    : imageMap.get(imagePath + "up2.png");
            case DOWN -> (player.getPosition().y % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD)
                    ? imageMap.get(imagePath + "down1.png")
                    : imageMap.get(imagePath + "down2.png");
            case LEFT -> (player.getPosition().x % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD)
                    ? imageMap.get(imagePath + "left1.png")
                    : imageMap.get(imagePath + "left2.png");
            case RIGHT -> (player.getPosition().x % ANIMATION_CYCLE_LENGTH < ANIMATION_FRAME_THRESHOLD)
                    ? imageMap.get(imagePath + "right1.png")
                    : imageMap.get(imagePath + "right2.png");
        };

        g2.drawImage(image, player.getPosition().x, player.getPosition().y, characterWidth, characterHeight, null);
    }
}
