package org.tricodex.view.assets;

import org.tricodex.model.manager.CellManager;
import org.tricodex.utils.settings.ScreenSettings;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AssetLoader {
    ScreenSettings screenSettings;
    public AssetLoader(ScreenSettings screenSettings) {
        this.screenSettings = screenSettings;

    }
    public void loadMap(CellManager cellManager, ScreenSettings screenSettings, int mapCellNum[][], String path) {
        try {
            InputStream is = getClass().getResourceAsStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < screenSettings.getMaxScreenTilesWidth() && row < screenSettings.getMaxScreenTilesHeight()) {
                String line = br.readLine();
                while (col < screenSettings.getMaxScreenTilesWidth()) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapCellNum[col][row] = num;
                    col++;
                }
                if (col == screenSettings.getMaxScreenTilesWidth()) {
                    col = 0;
                    row++;
                }
            }
            br.close();

        }catch (Exception e) {

        }
    }
}

