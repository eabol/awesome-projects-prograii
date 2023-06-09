package core;

import enumerators.TerrainType;
import view.SelectTerrain;

public class Terrain {

    private Position position;
    private TerrainType terrainType;
    private int positionValue;

    public Terrain(Position position, int terrainValue) {
        try {
            this.position = position;
            SelectTerrain.terrainSelection(terrainValue);
            this.positionValue = terrainValue;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value for terrainType: " + terrainValue);
        }
    }

    public int getType() {
        return positionValue;
    }

    public boolean isWalkable() {
        if (positionValue <= 6) {
            return true;
        } else if (positionValue <= 8) {
            return false;
        } else {
            throw new IllegalArgumentException("Invalid value for terrainType: " + getType());
        }
    }

    public Position getPosition() {
        return position;
    }

}
