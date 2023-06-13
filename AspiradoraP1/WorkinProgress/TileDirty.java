package WorkinProgress;

import WorkinProgress.Tile;

abstract public class TileDirty implements Tile {
    private int levelofDirt;

    public TileDirty(int levelofDirt){
        this.levelofDirt = levelofDirt;
    }

    @Override
    public void setLevelofDirt(int levelofDirt) {
        this.levelofDirt = levelofDirt;
    }

    @Override
    public int getLevelofDirt() {
        return levelofDirt;
    }
}
