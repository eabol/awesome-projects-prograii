package WorkinProgress;

import WorkinProgress.entity;

public abstract class entityInMovement implements entity {
    
    //attributes
    private int xCoordinate;
    private int yCoordinate;

    private String id;

    public entityInMovement(String id, int xCoordinate, int yCoordinate){
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public int getxCoordinate(){
        return xCoordinate;
    }
    public int getyCoordinate(){
        return yCoordinate;
    }

    public String id(){
        return id;
    }
    public void setPlace(int xCoordinate, int yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
    public abstract void move();
}
