package core.character;

import core.Terrain;
import core.transport.*;
import interfaces.Movement;
import enumerators.TerrainType;
import view.WorldHandler;

public abstract class GameCharacters implements Movement {

    Transport currentTransport;
    Terrain currentTerrain;
    WorldHandler gameWindow;
    KeyHandler keyHandler;
    void setTransport(Terrain terrain) {
        currentTransport = getTransportByTerrain(terrain.getType());
    }

    private Transport getTransportByTerrain(TerrainType terrainType) {
        switch (terrainType) {
            case ROAD, MEDIUMGRASS, GRASS -> {
                return new OnFoot();
            }
            case SAND -> {
                return new OnRug();
            }
            case WATER, TROUBLEDWATER -> {
                return new OnBoat();
            }
            case TALLGRASS -> {
                return new OnHorse();
            }
        }
        throw new IllegalArgumentException("Invalid value for terrainType: " + terrainType);
    }
}
