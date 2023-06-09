package view;

import view.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class TileManager {
    WorldHandler gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(WorldHandler gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        mazeParser("./src/main/resources/mazes/level1.txt");
    }
    public void mazeParser(String filePath){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int col = 0;
            int row = 0;
            while (((line = reader.readLine()) != null) && (col < gp.maxWorldCol && row < gp.maxWorldRow)) {
                line = line.replace("{", "").replace("}", "");
                String numbers[] = line.split(",");
                while(col < gp.maxWorldCol && col < numbers.length){
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol || col == numbers.length){
                    col = 0;
                    row++;
                }
            }
            reader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(BufferedReader reader, String[] numbers) {
        for (int col = 0; col < numbers.length; col++) {
            System.out.print(numbers[col]);
        }
        System.out.println();
    }
    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/road.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/sand.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/troubledwater.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/water.png"));

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/grass.png"));

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/mediumgrass.png"));

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/tallgrass.png"));

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/wall.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/TileImages/tree.png"));
            tile[8].collision = true;

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        //g2.drawImage(tile[0].image, 0, 0, gp.originalSize, gp.originalSize, null);
        //g2.drawImage(tile[1].image, 48, 0, gp.originalSize, gp.originalSize, null);
        //g2.drawImage(tile[2].image, 96, 0, gp.originalSize, gp.originalSize, null);
        //g2.drawImage(tile[3].image, 150, 0, gp.originalSize, gp.originalSize, null);

        int worldCol =0;
        int worldRow =0;
        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow){
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.originalSize;
            int worldY = worldRow * gp.originalSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            g2.drawImage(tile[tileNum].image, screenX, screenY, gp.originalSize, gp.originalSize, null);
            worldCol++;
            if (worldCol == gp.maxWorldCol){
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
