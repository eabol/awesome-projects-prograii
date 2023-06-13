package core.tile;

import enumerators.TerrainType;

import java.util.HashMap;
import java.util.Map;

public class TerrainMapper {
    private Map<Integer, TerrainType> terrainMap;

    public TerrainMapper() {
        terrainMap = new HashMap<>();
        terrainMap.put(1, TerrainType.ROAD);
        terrainMap.put(2, TerrainType.SAND);
        terrainMap.put(3, TerrainType.TROUBLEDWATER);
        terrainMap.put(4, TerrainType.WATER);
        terrainMap.put(5, TerrainType.GRASS);
        terrainMap.put(6, TerrainType.MEDIUMGRASS);
        terrainMap.put(7, TerrainType.TALLGRASS);
        terrainMap.put(8, TerrainType.WALL);
        terrainMap.put(9, TerrainType.TREE);
        terrainMap.put(10, TerrainType.PORTALEND);
        terrainMap.put(11, TerrainType.PORTALTRANSPORT);
    }

    public TerrainType mapTerrainType(int number) {
        return terrainMap.get(number);
    }

    private int type;

    public void Terrain(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
