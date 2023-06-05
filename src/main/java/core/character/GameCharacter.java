package src.main.java.core.character;

import src.main.java.core.Terrain   ;
import src.main.java.core.transport.*;
import src.main.java.interfaces.Movable;

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
