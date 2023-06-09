package main.java.core.character;

import main.java.core.Terrain   ;
import main.java.core.transport.*;
import main.java.interfaces.Movable;

import static main.java.enumerators.TerrainType.*;

public abstract class GameCharacter implements Movable {

    Transport currentTransport;
    Terrain currentTerrain;

    void setTransport(Terrain terrain){
        currentTransport = getTransportByTerrain(terrain);
    }
    private Transport getTransportByTerrain(Terrain terrain){
        switch (terrain.getType()) {
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
        throw new IllegalArgumentException("Invalid value for terrainType: " + terrain);
    }
}
