import java.util.Random;

public class Rain extends Problem{

    public Rain(String description) {
        super(description);
    }

    public Warning succes(){
        Random r= new Random();
        int probability=r.nextInt(100);

        if(probability<=5){

            return Warning.HEAVY_RAIN;
        } else if (probability<=15) {

            return Warning.WEAK_RAIN;
        }else{

            return Warning.NO_RAIN;
        }

    }


}
