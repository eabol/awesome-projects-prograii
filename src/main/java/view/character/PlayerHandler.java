package view.character;

import view.WorldHandler;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class PlayerHandler extends PlayerDrawer {
    WorldHandler gameWindow;
    KeyHandler keyHandler;
    public final int screenY;
    public final int screenX;

    public PlayerHandler(WorldHandler gameWindow, KeyHandler keyHandler) {
        this.gameWindow = gameWindow;
        this.keyHandler = keyHandler;
        screenX = gameWindow.screenWidth / 2 - (gameWindow.originalSize / 2);
        screenY = gameWindow.screenHeight / 2 - (gameWindow.originalSize / 2);
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        worldX = gameWindow.originalSize * 23;
        worldY = gameWindow.originalSize * 21;
        speed = 4;
        direction = "right1";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("./main/resources/playableGameCharacter/up1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream("./main/resources/playableGameCharacter/up2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/left1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/left2.png")));
            left3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/left3.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/right1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/right2.png")));
            right3 = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/right3.png")));
            upLeft = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/upLeft.png")));
            upRight = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader()
                    .getResourceAsStream("./main/resources/playableGameCharacter/upRight.png")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.inputKeyEvent) {
            try {
                if (keyHandler.getKeyName() == "upPressed") {
                    direction = "up";
                    worldY -= speed;
                }
                if (keyHandler.getKeyName() == "downPressed") {
                    direction = "down";
                    worldY += speed;
                }
                if (keyHandler.getKeyName() == "leftPressed") {
                    direction = "left";
                    worldX -= speed;
                }
                if (keyHandler.getKeyName() == "rightPressed") {
                    direction = "right";
                    worldX += speed;
                }
                spriteCounter++;
            } finally {
                if (spriteCounter > 40) {
                    if (spriteNum == 1) {
                        spriteNum = 2;
                    } else if (spriteNum == 2) {
                        spriteNum = 3;
                    } else if (spriteNum == 3) {
                        spriteNum = 1;
                    }
                    spriteCounter = 0;
                }
            }
        }
    }

    public void draw(Graphics2D g2d) {
        BufferedImage image = right1;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2) {
                    image = up2;
                    spriteNum = 1;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = right1;
                    spriteNum = 1;
                }
            }
            case "left" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2) {
                    image = left2;
                } else if (spriteNum == 3) {
                    image = left3;
                }
            }
            case "right" -> {
                if (spriteNum == 1) {
                    image = right1;
                } else if (spriteNum == 2) {
                    image = right2;
                } else if (spriteNum == 3) {
                    image = right3;
                }
            }
        }
        g2d.drawImage(image, screenX, screenY, gameWindow.originalSize, gameWindow.originalSize, null);
    }
}