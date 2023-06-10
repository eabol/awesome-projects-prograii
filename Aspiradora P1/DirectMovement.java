public abstract class DirectMovement extends entityInMovement{

    protected int movingdirection;

    private static final int[] X = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};

    public DirectMovement(String id, int xCoordinate, int yCoordinate, int movingdirection) {
        super(id, xCoordinate, yCoordinate);
        this.movingdirection = 0;
    }

    public void setMovingdirection(int movingdirection){
        if (movingdirection >=0 && movingdirection < 8){
        this.movingdirection = movingdirection;
        }
    }
    protected int[] getnextPosition(int getX,int getY,int direction){
            int[] nextPosition = new int[2];
            nextPosition[0] = getX + X[direction];
            nextPosition[1] = getY + Y[direction];
            return nextPosition;
        }
        //if (movingdirection < 0 || movingdirection > 7){
            //throw new IllegalArgumentException("Direction must be between 0 and 7");
        }



