package core.tile;

import enumerators.TerrainType;

import java.awt.image.BufferedImage;

public class Tile {
    public TerrainType terrainType;
    private BufferedImage image;
    public boolean collision;

    public Tile(BufferedImage image, boolean collision, TerrainType terrainType) {
        this.image = image;
        this.collision = collision;
        this.terrainType = terrainType;
    }

    public BufferedImage getImage() {
        return image;
    }
}
