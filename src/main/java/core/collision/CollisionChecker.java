package core.collision;

import core.character.Player;
import enumerators.TerrainType;
import enumerators.TransportTypes;
import view.WorldHandler;

public class CollisionChecker {
    WorldHandler gameWindow;

    public CollisionChecker(WorldHandler gameWindow) {
        this.gameWindow = gameWindow;
    }


    public void checkTile(Player player) {
        int playerLeftWorldX = player.getWorldX() + player.getSolidArea().x;
        int playerRightWorldX = player.getWorldX() + player.getSolidArea().x + player.getSolidArea().width;
        int playerTopWorldY = player.getWorldY() + player.getSolidArea().y;
        int playerBottomWorldY = player.getWorldY() + player.getSolidArea().y + player.getSolidArea().height;

        int playerLeftCol;
        int playerRightCol = playerRightWorldX / gameWindow.getOriginalSize();
        int playerTopRow = playerTopWorldY / gameWindow.getOriginalSize();
        int playerBottomRow = playerBottomWorldY / gameWindow.getOriginalSize();

        int tileNum1, tileNum2;


        switch (player.direction) {
            case UP -> {
                playerTopRow = (playerTopWorldY - player.speed) / gameWindow.getOriginalSize();
                checkCollision(player, playerRightCol, playerTopRow, playerBottomRow);
            }
            case DOWN -> {
                playerBottomRow = (playerBottomWorldY + player.speed) / gameWindow.getOriginalSize();
                checkCollision(player, playerRightCol, playerTopRow, playerBottomRow);
            }
            case LEFT -> {
                playerLeftCol = (playerLeftWorldX - player.speed) / gameWindow.getOriginalSize();
                tileNum1 = gameWindow.tileManager.getMapTileNum()[playerLeftCol][playerTopRow];
                tileNum2 = gameWindow.tileManager.getMapTileNum()[playerLeftCol][playerBottomRow];
                if (gameWindow.tileManager.tiles[tileNum1].collision || gameWindow.tileManager.tiles[tileNum2].collision) {
                    player.collision = true;
                }
            }
            case RIGHT -> {
                playerRightCol = (playerRightWorldX + player.speed) / gameWindow.getOriginalSize();
                checkCollision(player, playerRightCol, playerTopRow, playerBottomRow);
            }
        }

        getPlayerTransportType(player, playerRightCol, playerTopRow);

    }
    private void checkCollision(Player player, int playerRightCol, int playerTopRow, int playerBottomRow) {
        int tileNum1 = gameWindow.tileManager.getMapTileNum()[playerRightCol][playerTopRow];
        int tileNum2 = gameWindow.tileManager.getMapTileNum()[playerRightCol][playerBottomRow];

        if (gameWindow.tileManager.tiles[tileNum1].collision || gameWindow.tileManager.tiles[tileNum2].collision) {
            player.collision = true;
        }
    }

    public void getPlayerTransportType(Player player, int playerRightCol, int playerTopRow) {
        TerrainType currentTerrain = getTerrainAtPosition(playerRightCol, playerTopRow);

        switch (currentTerrain) {
            case WATER, TROUBLEDWATER -> player.setCurrentTransport(TransportTypes.BOAT);
            case TALLGRASS -> player.setCurrentTransport(TransportTypes.HORSE);
            case SAND -> player.setCurrentTransport(TransportTypes.CARPET);
            default -> player.setCurrentTransport(TransportTypes.FOOT);
        }
    }

    public TerrainType getTerrainAtPosition(int col, int row) {
        int tileNum = gameWindow.tileManager.getMapTileNum()[col][row];
        return gameWindow.tileManager.getTiles()[tileNum].terrainType;
    }
}
