package src.main.java.view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import src.main.java.view.tile.Tile;

public class TileManager {
    WorldHandler gp;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(WorldHandler gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        //tile = new Tile[gp.getTileCount()];

        //for (int i = 0; i < tile.length; i++) {
          //  tile[i] = new Tile(gp, i)
    }
    public void getTileImage() {
      //  for (int i = 0; i < tile.length; i++) {
        //    tile[i] = new Tile(gp, i);
        //}
    try{
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/main/resources/TileImages/road.png"));
    } catch (IOException e){
        e.printStackTrace();
    }
    }
    public void draw(Graphics2D g2){
        g2.drawImage(tile[0].image, 0, 0, gp.originalSize, gp.originalSize, null);
        int col =0;
        int row =0;
        int x  = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            x = col * gp.originalSize;
            y = row * gp.originalSize;
            g2.drawImage(tile[0].image, x, y, gp.originalSize, gp.originalSize, null);
            col++;
            if (col == gp.maxScreenCol){
                col = 0;
                row++;
            }
        }
    }
}
