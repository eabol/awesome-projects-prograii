package core;

import enumerators.TerrainType;

public class Terrain {

    private Position position;
    private TerrainType terrainType;
        public Terrain(Position position, String terrainType) {
            this.position = position;
            for (TerrainType terrainTypeConstant : TerrainType.values()) {
                if (terrainTypeConstant.name().equalsIgnoreCase(terrainType)) {
                    this.terrainType = terrainTypeConstant;
                    return;
                }
            }

            throw new IllegalArgumentException("Invalid value for terrainType: " + terrainType);
    }

    public TerrainType getType() {
            return terrainType;
    }
    public boolean isWalkable() {
        switch (getType()) {
            case ROAD, MEDIUMGRASS, GRASS, TALLGRASS, WATER, TROUBLEDWATER, SAND -> {
                return true;
            }
            case WALL, TREE -> {
                return false;
            }
        }
        throw new IllegalArgumentException("Invalid value for terrainType: " + getType());
    }

    public Position getPosition() {
            return position;
    }

    public String getPositionAsString() {
        return (position.getX() + "," + position.getY());
    }
}
