import Points.Droweable;

public class PowerUp extends Point implements Droweable {

    private int duration;

    public PowerUp(int x, int y){
        super(x,y,value);
        this.duration = duration;
    }

    @Override
    public void Draw() {

    }


    public int getDuration() {
        return 0;
    }
}
