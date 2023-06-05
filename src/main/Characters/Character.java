package src.main.Characters;

import src.main.Terrains.Terrain;
import src.main.Transports.Transport;

public abstract class Character {

    public Transport transport;
    public Terrain actualTerrain;

    public void move() {
    };

    private boolean ableToWalkBy(Terrain terrain) {
        return false;
    }
}
