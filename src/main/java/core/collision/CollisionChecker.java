package core.collision;

import core.character.Player;
import enumerators.GameState;
import enumerators.TerrainType;
import enumerators.TransportTypes;
import view.WorldHandler;

import static enumerators.TerrainType.PORTALTRANSPORT;

public class CollisionChecker extends WorldCollisions {
    static WorldHandler gameWindow;
    private String endGameMessage = "";

    public CollisionChecker(WorldHandler gameWindow) {
        super();
        this.gameWindow = gameWindow;
    }

    public void checkTile(Player player) {
        playerLeftWorldX = player.getWorldX() + player.getSolidArea().x;
        playerRightWorldX = player.getWorldX() + player.getSolidArea().x + player.getSolidArea().width;
        playerTopWorldY = player.getWorldY() + player.getSolidArea().y;
        playerBottomWorldY = player.getWorldY() + player.getSolidArea().y + player.getSolidArea().height;

        playerRightCol = playerRightWorldX / gameWindow.getOriginalSize();
        playerTopRow = playerTopWorldY / gameWindow.getOriginalSize();
        playerBottomRow = playerBottomWorldY / gameWindow.getOriginalSize();

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
                if (gameWindow.tileManager.tiles[tileNum1].collision
                        || gameWindow.tileManager.tiles[tileNum2].collision) {
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

    protected void checkCollision(Player player, int playerRightCol, int playerTopRow, int playerBottomRow) {
        tileNum1 = gameWindow.tileManager.getMapTileNum()[playerRightCol][playerTopRow];
        tileNum2 = gameWindow.tileManager.getMapTileNum()[playerRightCol][playerBottomRow];

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
            case PORTALTRANSPORT, PORTALEND -> getFinalGame(currentTerrain);
            default -> player.setCurrentTransport(TransportTypes.FOOT);
        }
    }

    public static void getFinalGame(TerrainType currentTerrain) {
        if (currentTerrain == PORTALTRANSPORT) {
            gameWindow.tileManager.parseMaze("./src/main/resources/mazes/level3.txt");
            System.out.println("You have reached the end of the game!");
        } else {
            WorldHandler.gameState = GameState.GAME_OVER;
        }
    }

    public TerrainType getTerrainAtPosition(int col, int row) {
        tileNum = gameWindow.tileManager.getMapTileNum()[col][row];
        return gameWindow.tileManager.getTiles()[tileNum].terrainType;
    }

}
