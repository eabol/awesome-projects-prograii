package org.tricodex.model.map;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class MapLoader {
    private final ScreenSettings screenSettings;
    private final CellManager cellManager;
    private int[][] mapCellNum;
    private Random random;

    public MapLoader(ScreenSettings screenSettings, CellManager cellManager) {
        this.screenSettings = screenSettings;
        this.cellManager = cellManager;
        this.mapCellNum = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];
        this.random = new Random(); // Random number generator
    }

    public void loadMap(String path) {
        if (mapCellNum.length != screenSettings.getMaxScreenTilesWidth() ||
                mapCellNum[0].length != screenSettings.getMaxScreenTilesHeight()) {
            mapCellNum = new int[screenSettings.getMaxScreenTilesWidth()][screenSettings.getMaxScreenTilesHeight()];
        }

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
                int cellValue = numbers[col].charAt(0) - '0'; // Assumes single-digit numbers
                if (cellValue == 1 && random.nextInt(20) == 0) { // 10% chance to convert '1' to '2'
                    cellValue = 2;
                }
                mapCellNum[col][row] = cellValue;
            }
        }
    }
}
