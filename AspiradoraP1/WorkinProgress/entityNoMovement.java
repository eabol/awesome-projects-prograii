package WorkinProgress;

import WorkinProgress.entity;

public abstract class entityNoMovement extends entity {


    public entityNoMovement(String id, int xCoordinate, int yCoordinate){
        this.id = id;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
