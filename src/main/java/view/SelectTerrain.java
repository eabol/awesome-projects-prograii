package view;

import enumerators.TerrainType;
import java.awt.*;

public class SelectTerrain {

    public static Color terrainSelection(TerrainType type) {
        switch (type) {
            case ROAD -> {
                return Color.GRAY;
            }
            case MEDIUMGRASS -> {
                return Color.GREEN;
            }
            case GRASS -> {
                return Color.LIGHT_GRAY;
            }
            case TALLGRASS -> {
                return Color.DARK_GRAY;
            }
            case WATER -> {
                return Color.CYAN;
            }
            case TROUBLEDWATER -> {
                return Color.BLUE;
            }
            case SAND -> {
                return Color.YELLOW;
            }
            case WALL -> {
                return Color.ORANGE;
            }
            case TREE -> {
                return Color.MAGENTA;
            }
        }
        throw new IllegalArgumentException("Invalid Terrain");
    }
}
