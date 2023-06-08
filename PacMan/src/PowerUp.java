public class PowerUp extends Point implements Droweable{

    private int duration;

    public PowerUp(int x, int y,int value,int duration){
        super(x,y,value);
        this.duration = duration;
    }

    @Override
    public void Draw() {

    }


}
