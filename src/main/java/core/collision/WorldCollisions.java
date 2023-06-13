package core.collision;

import core.character.Player;
import enumerators.TerrainType;
import view.WorldHandler;

public abstract class WorldCollisions {
    WorldHandler gameWindow;
    int playerLeftWorldX;
    int playerRightWorldX;
    int playerTopWorldY;
    int playerBottomWorldY;
    int playerLeftCol;
    int playerRightCol;
    int playerTopRow;
    int playerBottomRow;
    int tileNum1, tileNum2;
    int tileNum;

    public void checkTile(Player player) {
    }

    protected void checkCollision(Player player, int playerRightCol, int playerTopRow, int playerBottomRow) {
    }

    public void getPlayerTransportType(Player player, int playerRightCol, int playerTopRow) {
    }

    public TerrainType getTerraintAtPosition(int col, int row) {
        return gameWindow.tileManager.getTiles()[tileNum].terrainType;
    }
}
