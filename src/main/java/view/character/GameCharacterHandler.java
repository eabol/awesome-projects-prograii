package view.character;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCharacterHandler {
    public int worldX, worldY, speed;
    public BufferedImage upLeft, upRight, left1, right1, left2, left3, right2, right3, up1, up2;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int screenX;
    public int screenY;
    public Rectangle solidArea;
    public boolean collision = false;

    public void update() {
    }

    public void draw(Graphics2D g2d) {
    }
}