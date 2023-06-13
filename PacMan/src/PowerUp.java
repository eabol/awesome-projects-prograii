public class PowerUp extends Point implements Droweable{

    private int duration=15;

    public PowerUp(int x, int y){
        super(x,y,6);

    }


    @Override
    public void Draw(Map map) {
        map.grid[this.x][this.y]= 2;
    }

    @Override
    public void Draw() {

    }
}
