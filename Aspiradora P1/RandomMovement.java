import java.util.Random;
public abstract class RandomMovement extends entityInMovement {
    private Random randomnumber;

    private static final int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};


    public RandomMovement(String id, int xCoordinate, int yCoordinate){
        super(id, xCoordinate, yCoordinate);
        this.randomnumber = new Random();
    }

    protected boolean oktomove;// falta hacer que el board sepa si hay un obstaculo o no

    protected int randomDirection(){
        return randomnumber.nextInt(8);
    }
    protected int[] getnextPosition(int getX,int getY,int direction){
        int[] nextPosition = new int[2];
        nextPosition[0] = getX + X[direction];
        nextPosition[1] = getY + Y[direction];
        return nextPosition;
    }

    }



