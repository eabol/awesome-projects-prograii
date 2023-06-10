package view.collision;

import view.WorldHandler;
import view.character.PlayerHandler;

public class CollisionChecker {
    WorldHandler gameWindow;

    public CollisionChecker(WorldHandler gameWindow) {
        this.gameWindow = gameWindow;
    }

    public void checkTile(PlayerHandler player) {
        int playerLeftWorldX = player.worldX + player.solidArea.x;
        int playerRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
        int playerTopWorldY = player.worldY + player.solidArea.y;
        int playerBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;

        int playerLeftCol = playerLeftWorldX / gameWindow.originalSize;
        int playerRightCol = playerRightWorldX / gameWindow.originalSize;
        int playerTopRow = playerTopWorldY / gameWindow.originalSize;
        int playerBottomRow = playerBottomWorldY / gameWindow.originalSize;

        int tileNum1, tileNum2;

        switch (player.direction) {
            case "up":
                playerTopRow = (playerTopWorldY - player.speed) / gameWindow.originalSize;
                tileNum1 = gameWindow.tileManager.mapTileNum[playerLeftCol][playerTopRow];
                tileNum2 = gameWindow.tileManager.mapTileNum[playerRightCol][playerTopRow];
                if (gameWindow.tileManager.tile[tileNum1].collision == true
                        || gameWindow.tileManager.tile[tileNum2].collision == true) {
                    player.collision = true;
                }
                break;
            case "down":
                playerBottomRow = (playerBottomWorldY + player.speed) / gameWindow.originalSize;
                tileNum1 = gameWindow.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                tileNum2 = gameWindow.tileManager.mapTileNum[playerRightCol][playerBottomRow];
                if (gameWindow.tileManager.tile[tileNum1].collision == true
                        || gameWindow.tileManager.tile[tileNum2].collision == true) {
                    player.collision = true;
                }
                break;
            case "left":
                playerLeftCol = (playerLeftWorldX - player.speed) / gameWindow.originalSize;
                tileNum1 = gameWindow.tileManager.mapTileNum[playerLeftCol][playerTopRow];
                tileNum2 = gameWindow.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
                if (gameWindow.tileManager.tile[tileNum1].collision == true
                        || gameWindow.tileManager.tile[tileNum2].collision == true) {
                    player.collision = true;
                }
                break;
            case "right":
                playerRightCol = (playerRightWorldX - player.speed) / gameWindow.originalSize;
                tileNum1 = gameWindow.tileManager.mapTileNum[playerRightCol][playerTopRow];
                tileNum2 = gameWindow.tileManager.mapTileNum[playerRightCol][playerBottomRow];
                if (gameWindow.tileManager.tile[tileNum1].collision == true
                        || gameWindow.tileManager.tile[tileNum2].collision == true) {
                    player.collision = true;
                }
                break;
        }
    }
}
