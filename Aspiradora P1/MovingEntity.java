package vacuum;

public abstract class MovingEntity{

    int id;
    int xCoordinate;
    int yCoordinate;

    public MovingEntity(){

    }
    public MovingEntity(int id, int xCoordinate, int yCoordinate) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    protected void RMovement(){
        int[] X={0, 1, 1, 1, 0, -1, -1, -1};
        int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};
        int direction = (int)(Math.random()*8);

        this.xCoordinate = this.xCoordinate + X[direction];
        this.yCoordinate = this.yCoordinate + Y[direction];


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    //aun abierta a cambios, pero completamente implementada a Cat y Vacuum cleaner
}
