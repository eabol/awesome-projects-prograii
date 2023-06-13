package view;

import core.tile.Tile;
import enumerators.TerrainType;
import view.enviroment.LightHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TileManager {
    private WorldHandler gameWindow;
    private LightHandler lightHandler;

    public Tile[] getTiles() {
        TerrainType terrainType;
        return tiles;
    }

    public Tile[] tiles;
    private int[][] mapTileNum;

    public TileManager(WorldHandler gameWindow) {
        this.gameWindow = gameWindow;
        this.tiles = new Tile[11];
        this.mapTileNum = new int[gameWindow.getMaxWorldCol()][gameWindow.getMaxWorldRow()];
        this.lightHandler = new LightHandler(gameWindow, 350);
        loadTileImages();
        parseMaze("./src/main/resources/mazes/level2.txt");
    }


    public void parseMaze(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            int col = 0;
            int row = 0;
            while (((line = reader.readLine()) != null)
                    && (col < gameWindow.getMaxWorldCol() && row < gameWindow.getMaxWorldRow())) {
                line = line.replace("{", "").replace("}", "");
                String[] numbers = line.split(",");
                while (col < gameWindow.getMaxWorldCol() && col < numbers.length) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gameWindow.getMaxWorldCol() || col == numbers.length) {
                    col = 0;
                    row++;
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTileImages() {
        try {

            tiles[0] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/road.png")), false,
                    TerrainType.ROAD);
            tiles[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/mediumgrass.png")), false,
                    TerrainType.MEDIUMGRASS);
            tiles[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/grass.png")), false,
                    TerrainType.GRASS);
            tiles[3] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/tallgrass.png")), false,
                    TerrainType.TALLGRASS);
            tiles[4] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/water.png")), false,
                    TerrainType.WATER);
            tiles[5] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/troubledwater.png")), false,
                    TerrainType.TROUBLEDWATER);
            tiles[6] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/sand.png")), false,
                    TerrainType.SAND);
            tiles[7] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/wall.png")), true,
                    TerrainType.WALL);
            tiles[8] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/tree.png")), true,
                    TerrainType.TREE);

            tiles[9] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/water.png")), false,
                    TerrainType.PORTALEND);
            tiles[10] = new Tile(ImageIO.read(getClass().getResourceAsStream("/TileImages/sand.png")), false,
                    TerrainType.PORTALTRANSPORT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        int worldCol = 0;
        int worldRow = 0;
        while (worldCol < gameWindow.getMaxWorldCol() && worldRow < gameWindow.getMaxWorldRow()) {
            int tileNum = mapTileNum[worldCol][worldRow];
            int worldX = worldCol * gameWindow.getOriginalSize();
            int worldY = worldRow * gameWindow.getOriginalSize();
            int screenX = worldX - gameWindow.getPlayer().getWorldX() + gameWindow.getPlayer().getScreenX();
            int screenY = worldY - gameWindow.getPlayer().getWorldY() + gameWindow.getPlayer().getScreenY();
            g2d.drawImage(tiles[tileNum].getImage(), screenX, screenY, gameWindow.getOriginalSize(),
                    gameWindow.getOriginalSize(), null);
            worldCol++;
            if (worldCol == gameWindow.getMaxWorldCol()) {
                worldCol = 0;
                worldRow++;
            }
        }
    }

    public int[][] getMapTileNum() {
        return mapTileNum;
    }
}
