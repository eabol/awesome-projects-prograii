import java.util.Random;
public class TileCleaned implements Tiles{

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
