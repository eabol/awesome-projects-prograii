package Main;

import java.util.Random;
public class Car extends Circumstances {
    public Car() {
    }
    public Warning succes(){
        Random r= new Random();
        int probability=r.nextInt(100);
        if(probability<=35){
            return Warning.CAR_PASS ;
        }else {
            return Warning.CAR_NOT_PASS;
        }
    }
    public void setDescription() {
        super.setDescription("The car passed");
    }

}
