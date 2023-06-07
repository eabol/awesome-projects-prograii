package org.tricodex.model.map;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MapLoader {
    private final ScreenSettings screenSettings;
    private final CellManager cellManager;

    public MapLoader(ScreenSettings screenSettings, CellManager cellManager) {
        this.screenSettings = screenSettings;
        this.cellManager = cellManager;
    }

    public void loadMap(String path) {
        System.out.println("Loading map: " + path);
        int[][] mapCellNum = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(path)))) {
            fillMapArray(br, mapCellNum);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load map: " + path, e);
        }

        cellManager.setMapCellNumber(mapCellNum);
    }

    private void fillMapArray(BufferedReader br, int[][] mapCellNum) throws IOException {
        int maxTilesHeight = screenSettings.getMaxScreenTilesHeight();
        int maxTilesWidth = screenSettings.getMaxScreenTilesWidth();

        for (int row = 0; row < maxTilesHeight; row++) {
            String line = br.readLine();
            if (line == null) {
                break;
            }

            String[] numbers = line.split(" ");
            for (int col = 0; col < maxTilesWidth && col < numbers.length; col++) {
                mapCellNum[col][row] = Integer.parseInt(numbers[col]);
            }
        }
    }
}
