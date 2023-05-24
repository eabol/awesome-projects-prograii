import java.util.Random;

public class tier {

    public tier() {
    }

    public int getValue(int min, int max){
        Random r = new Random();
        return r.nextInt(max-min+1)+min;
    }
}
