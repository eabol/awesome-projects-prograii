import java.util.Random;

public class Car {
    public static boolean succes(){
        Random r= new Random();
        int probability=r.nextInt(100);
        if(probability<=35){
            return true;
        }return false;
    }
}
