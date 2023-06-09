package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import view.tile.Tile;

public class TileManager {
    WorldHandler gameWindow;
    Tile[] tile;
    public int mapTileNum[][];

    public TileManager(WorldHandler gameWindow) {
        this.gameWindow = gameWindow;
        tile = new Tile[10];
        mapTileNum = new int[gameWindow.maxWorldCol][gameWindow.maxWorldRow];
        getTileImage();
        mazeParser("./src/main/resources/mazes/level1.txt");
    }

    public void mazeParser(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int col = 0;
            int row = 0;
            while (((line = reader.readLine()) != null)
                    && (col < gameWindow.maxWorldCol && row < gameWindow.maxWorldRow)) {
                line = line.replace("{", "").replace("}", "");
                String numbers[] = line.split(",");
                while (col < gameWindow.maxWorldCol && col < numbers.length) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gameWindow.maxWorldCol || col == numbers.length) {
                    col = 0;
                    row++;
                }
            }
            reader.close();
        } catch (IOException e) {
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
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/src/main/resources/TileImages/road.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/src/main/resources/TileImages/sand.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/src/main/resources/TileImages/water.png"));

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/src/main/resources/TileImages/tree.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < gameWindow.maxWorldCol && worldRow < gameWindow.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gameWindow.originalSize;
            int worldY = worldRow * gameWindow.originalSize;
            int screenX = worldX - gameWindow.player.worldX + gameWindow.player.screenX;
            int screenY = worldY - gameWindow.player.worldY + gameWindow.player.screenY;
            g2.drawImage(tile[tileNum].image, screenX, screenY, gameWindow.originalSize, gameWindow.originalSize, null);
            worldCol++;
            if (worldCol == gameWindow.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
