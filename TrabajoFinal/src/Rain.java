import java.util.Random;

public class Rain extends Problem{

    public Rain(String description) {
        super(description);
    }

    public int succes(){
        Random r= new Random();
        int probability=r.nextInt(100);
        if(probability<=5){
            System.out.println("Lluvia fuerte");
            return 5;
        } else if (probability<=15) {
            System.out.println("Lluvia debil");
            return 2;
        }else{
            System.out.println("No llueve");
            return 0;
        }

    }


}
