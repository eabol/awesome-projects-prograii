package vacuum;

public abstract class MovingEntity{

    int id;
    int xCoordinate;
    int yCoordinate;

    boolean automated;

    public MovingEntity(){

    }
    public MovingEntity(int id, int xCoordinate, int yCoordinate, boolean automated) {
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.automated = automated;
    }

    protected void RMovement(){
        int[] X={0, 1, 1, 1, 0, -1, -1, -1};
        int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};
        int direction = (int)(Math.random()*8);

        this.xCoordinate = this.xCoordinate + X[direction];
        this.yCoordinate = this.yCoordinate + Y[direction];


    }


    protected void DMovement(){

        System.out.println("Elija direccion");
        int[] X={0, 1, 1, 1, 0, -1, -1, -1};
        int[] Y = {-1, -1, 0, 1, 1, 1, 0, -1};
        int input = Controller.takePlayerInput();
        int direction = Character.getNumericValue(input);

        setXCoordinate(this.xCoordinate + X[direction]);
        setYCoordinate(this.yCoordinate + Y[direction]);

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

    public boolean getAutomated() {
        return automated;
    }

    public void setAutomated(boolean automated) {
        this.automated = automated;
    }

    //aun abierta a cambios, pero completamente implementada a Cat y Vacuum cleaner
}
