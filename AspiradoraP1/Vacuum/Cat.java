package Vacuum;

public class Cat extends MovingEntity {
    Boolean isPresent;

    public Cat(int id, int xCoordinate, int yCoordinate, boolean automated, Boolean isPresent) {
        super(id, xCoordinate, yCoordinate, automated);
        this.isPresent = isPresent;

    }

    public void mightSpawnOrDeSpawn(){
        if (!isPresent&&((int)(Math.random()*100+1)>=85)){
            isPresent = true;
        } else if (isPresent&&((int)(Math.random()*100+1)>=80)){
            isPresent = false;
        }
    }

}
