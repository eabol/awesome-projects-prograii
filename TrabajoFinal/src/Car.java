import java.util.Random;

public class Car extends Problem{


    public Car(String description) {
        super(description);
    }

    public boolean succes(){
        Random r= new Random();
        int probability=r.nextInt(100);
        if(probability<=35){
            System.out.println("El coche ha pasado");
            return true;
        }else {

            System.out.println("El coche no ha pasado");
            return false;
        }
    }
}
