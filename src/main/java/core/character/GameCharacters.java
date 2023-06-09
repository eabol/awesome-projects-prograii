package core.character;

import core.Terrain;
import core.transport.*;
import interfaces.Movement;

public abstract class GameCharacters implements Movement {

    Transport currentTransport;
    Terrain currentTerrain;

    void setTransport(Terrain terrain) {
        currentTransport = getTransportByTerrain(terrain);
    }

    private Transport getTransportByTerrain(Terrain terrain) {
        if (terrain.getType() <= 2) {
            return new OnFoot();
        } else if (terrain.getType() == 6) {
            return new OnRug();
        } else if (terrain.getType() == 4 || terrain.getType() == 5) {
            return new OnBoat();
        } else if (terrain.getType() == 3) {
            return new OnHorse();
        }
        throw new IllegalArgumentException("Invalid value for terrainType: " + terrain);
    }
}
