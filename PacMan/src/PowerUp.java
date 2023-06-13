public class PowerUp extends Point implements Droweable{

    private int duration=15;

    public PowerUp(int x, int y){
        super(x,y,6);

    }

    @Override
    public void Draw() {
        System.out.print("+");
    }


}
