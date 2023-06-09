package view;

import enumerators.TerrainType;
import java.awt.*;

public class SelectTerrain {

    public static Color terrainSelection(int number) {
        switch (number) {
            case 0 -> {
                return Color.CYAN; // Road
            }
            case 1 -> {
                return Color.GREEN; // MediumGrass
            }
            case 2 -> {
                return Color.LIGHT_GRAY; // Grass
            }
            case 3 -> {
                return Color.DARK_GRAY; // TallGrass
            }
            case 4 -> {
                return Color.CYAN; // Water
            }
            case 5 -> {
                return Color.BLUE; // TroubledWater
            }
            case 6 -> {
                return Color.YELLOW; // Sand
            }
            case 7 -> {
                return Color.ORANGE; // Wall
            }
            case 8 -> {
                return Color.MAGENTA; // Tree
            }
        }
        throw new IllegalArgumentException("Invalid Terrain");
    }
}
