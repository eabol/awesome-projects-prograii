package src.main.Terrains;

public class Terrain {
    public Position position;
    public TerrainTypes terrainType;

    public Terrain(Position position, TerrainTypes terrainType) {
        this.position = position;
        this.terrainType = terrainType;
    }
}
