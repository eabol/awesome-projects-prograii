package view.collision;

import view.WorldHandler;
import view.character.PlayableGameCharacterHandler;

public class CollisionChecker {
    WorldHandler gp;
    public CollisionChecker(WorldHandler gp){
        this.gp = gp;
    }
    public void checkTile(PlayableGameCharacterHandler player ){
    int playerLeftWorldX = player.worldX + player.solidArea.x;
    int playerRightWorldX = player.worldX + player.solidArea.x + player.solidArea.width;
    int playerTopWorldY = player.worldY + player.solidArea.y;
    int playerBottomWorldY = player.worldY + player.solidArea.y + player.solidArea.height;

    int playerLeftCol = playerLeftWorldX / gp.originalSize;
    int playerRightCol = playerRightWorldX / gp.originalSize;
    int playerTopRow = playerTopWorldY / gp.originalSize;
    int playerBottomRow = playerBottomWorldY / gp.originalSize;

    int tileNum1, tileNum2;

    switch (player.direction){
        case "up":
            playerTopRow = (playerTopWorldY - player.speed) / gp.originalSize;
            tileNum1 = gp.tileManager.mapTileNum[playerLeftCol][playerTopRow];
            tileNum2 = gp.tileManager.mapTileNum[playerRightCol][playerTopRow];
            if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true)
            {player.collision = true;}
            break;
        case "down":
            playerBottomRow = (playerBottomWorldY + player.speed) / gp.originalSize;
            tileNum1 = gp.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
            tileNum2 = gp.tileManager.mapTileNum[playerRightCol][playerBottomRow];
            if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true)
            {player.collision = true;}
            break;
        case "left":
            playerLeftCol = (playerLeftWorldX - player.speed) / gp.originalSize;
            tileNum1 = gp.tileManager.mapTileNum[playerLeftCol][playerTopRow];
            tileNum2 = gp.tileManager.mapTileNum[playerLeftCol][playerBottomRow];
            if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true)
            {player.collision = true;}
            break;
        case "right":
            playerRightCol = (playerRightWorldX - player.speed) / gp.originalSize;
            tileNum1 = gp.tileManager.mapTileNum[playerRightCol][playerTopRow];
            tileNum2 = gp.tileManager.mapTileNum[playerRightCol][playerBottomRow];
            if (gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true)
            {player.collision = true;}
            break;
    }
    }
}
