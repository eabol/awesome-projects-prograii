public class Food extends Point implements Droweable{

    public Food(int x, int y) {
        super(x, y,3);
    }

    @Override
    public void Draw(Map map) {
        map.grid[this.x][this.y]= 3;
    }

    @Override
    public void Draw() {

    }
}
