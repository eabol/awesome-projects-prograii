public abstract class Cat extends RandomMovement {

    public Cat(String id,int xCoordinate, int yCoordinate) {
        super(id,xCoordinate,yCoordinate);
    }
    @Override
    public void move(){
       int movingdirection = randomDirection();
         int [] newPosition = getnextPosition(getxCoordinate(),getyCoordinate(),movingdirection);
         int newX = newPosition[0];
         int newY = newPosition[1];
         setPlace(newX,newY);
    }
}
