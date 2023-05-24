import java.util.Random;

public class Rain{
    public static int succes(){
        Random r= new Random();
        int probability=r.nextInt(100);
        if(probability<=5){
            return 5;
        } else if (probability<=15) {
            return 2;
        }else{
            return 0;
        }

    }


}
