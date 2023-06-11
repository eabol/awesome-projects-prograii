public class TileDirty implements Tiles{
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
