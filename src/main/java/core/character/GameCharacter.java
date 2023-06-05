package core.character;

import core.Terrain   ;
import core.transport.*;
import interfaces.Movable;

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
