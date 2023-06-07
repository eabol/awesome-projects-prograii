package core;

import java.util.ArrayList;
import java.util.Random;

public class Maze {
    private ArrayList<ArrayList<Terrain>> map;

    public Maze(String[][] terrainData) {
        this.map = generateTerrain(terrainData);
    }

    public ArrayList<ArrayList<Terrain>> generateTerrain(String[][] data) {
        ArrayList<ArrayList<Terrain>> arrayList = new ArrayList<>();

        for (int y = 0; y < data.length; y++) {
            String[] row = data[y];
            ArrayList<Terrain> innerList = new ArrayList<>();
            for (int x = 0; x < row.length; x++) {
                innerList.add(new Terrain(new Position(x, y), row[x]));
            }
            arrayList.add(innerList);
        }

        return arrayList;
    }

    public Terrain getRandomOccupableTerrain() {
        Random random = new Random();
        ArrayList<Terrain> row = map.get(random.nextInt(map.size()));
        Terrain terrain = row.get(random.nextInt(row.size()));
        if (terrain.isWalkable()) {
            // System.out.println(terrain.getType()+" : "+terrain.isWalkable() + " : " +
            // terrain.getPositionAsString() + " : " + terrain);
            return terrain;
        }
        return getRandomOccupableTerrain();
    }

    public int getMapXSize() {
        return map.get(0).size();
    }

    public int getMapYSize() {
        return map.size();
    }

    public Terrain getTerrainByPosition(int x, int y) {
        return map.get(y).get(x);
    }
}
