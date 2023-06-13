package vacuum;

public class Cat extends MovingEntity implements Entity{
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

    public void checkCat(Cat C1){
        if (C1.isPresent) {
            System.out.println("the cat's current coordinates: "
                    + C1.getXCoordinate() + "," + C1.getYCoordinate());
        }
    }

    public Boolean getPresent() {
        return isPresent;
    }

    public void setPresent(Boolean present) {
        isPresent = present;
    }
}
