package view.character;

import view.WorldHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PlayableGameCharacterHandler extends GameCharacterHandler {
    WorldHandler gp;
    KeyHandler keyH;

    public PlayableGameCharacterHandler(WorldHandler gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        this.screenX = gp.screenWidth/2 - (gp.originalSize/2);
        this.screenY = gp.screenHeight/2 - (gp.originalSize/2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 12;
        solidArea.height = 32;
        setDefaultValue();
        getPlayerImage();
    }

    public void setDefaultValue() {
        worldX = gp.originalSize * 23;
        worldY = gp.originalSize * 21;
        speed = 4;
        direction = "right1";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/up2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/left2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/right2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/right3.png"));
            upLeft = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/upLeft.png"));
            upRight = ImageIO.read(getClass().getResourceAsStream("/playableGameCharacter/upRight.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed
                || keyH.downPressed
                || keyH.leftPressed
                || keyH.rightPressed
        ) {
            if (keyH.upPressed) {
                direction = "up";

            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }

//Check the collision
            collision = false;
            gp.collisionChecker.checkTile(this);

            //if colletion is false
            if(collision == false) {
                switch (direction){
                    case "up": worldY -= speed; break;
                    case "down": worldY += speed; break;
                    case "left": worldX -= speed; break;
                    case "right": worldX += speed; break;
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
        g2d.drawImage(image, screenX, screenY, gp.characterWidth, gp.characterHeight, null);
    }
}