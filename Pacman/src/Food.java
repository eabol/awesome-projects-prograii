import Points.Droweable;

public class Food extends Point implements Droweable {
    public Food(int x, int y, int value) {
        super(x, y, value);
    }

    public Food(int x, int y) {
        super();
    }

    @Override
    public void Draw() {

    }
}
