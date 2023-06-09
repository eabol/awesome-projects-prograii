package view.character;

import view.WorldHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerHandler extends PlayerDrawer {
    WorldHandler gameWindow;
    KeyHandler keyHandler;

    public PlayerHandler(WorldHandler gameWindow, KeyHandler keyHandler) {
        this.gameWindow = gameWindow;
        this.keyHandler = keyHandler;
        this.screenX = gameWindow.screenWidth / 2 - (gameWindow.originalSize / 2);
        this.screenY = gameWindow.screenHeight / 2 - (gameWindow.originalSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 12;
        solidArea.height = 32;
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        worldX = gameWindow.originalSize * 1;
        worldY = gameWindow.originalSize * 1;
        speed = 4;
        direction = "right1";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/up2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/right3.png"));
            upLeft = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/upLeft.png"));
            upRight = ImageIO.read(getClass().getResourceAsStream("/PlayerImages/upRight.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.inputKeyEvent) {
            if (keyHandler.getKeyName() == "upPressed") {
                direction = "up";
            }
            if (keyHandler.getKeyName() == "downPressed") {
                direction = "down";
            }
            if (keyHandler.getKeyName() == "leftPressed") {
                direction = "left";
            }
            if (keyHandler.getKeyName() == "rightPressed") {
                direction = "right";
            }

            collision = false;
            gameWindow.collisionChecker.checkTile(this);

            // if colletion is false
            if (collision == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
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

    public void draw(Graphics2D g2d) {
        BufferedImage image = right1;
        switch (direction) {
            case "up" -> {
                if (spriteNum == 1) {
                    image = up1;
                } else if (spriteNum == 2 || spriteNum == 3) {
                    image = up2;
                }
            }
            case "down" -> {
                if (spriteNum == 1) {
                    image = left1;
                } else if (spriteNum == 2 || spriteNum == 3) {
                    image = right1;
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
        g2d.drawImage(image, screenX, screenY, gameWindow.characterWidth, gameWindow.characterHeight, null);
    }
}