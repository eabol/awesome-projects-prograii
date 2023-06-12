public class TileCleaned implements Tile {

    private int levelofDirt;

    public void CleanTile(){
        levelofDirt = 0;
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
