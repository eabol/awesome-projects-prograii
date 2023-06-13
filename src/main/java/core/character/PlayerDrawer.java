package core.character;

import enumerators.Directions;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class PlayerDrawer {
    public int worldX;
    public int worldY;
    public int speed;
    public Directions direction;
    public int screenX;
    public int screenY;

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getWorldX() {
        return worldX;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public Rectangle solidArea;
    public boolean collision = false;

    public void update() {
    

    public void draw(Graphics2D g2d) {
}