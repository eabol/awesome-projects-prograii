package interfaces;

import java.awt.Graphics2D;

public interface TilesDistribution {

    public void parseMaze(String filePath);

    public void loadTileImages();

    public void draw(Graphics2D g2d);

    public int[][] getMapTileNum();
}
