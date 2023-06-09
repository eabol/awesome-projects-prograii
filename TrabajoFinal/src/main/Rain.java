package Main;

import java.util.Random;

public class Rain {

    public Rain() {
    }

    public Warning succes() {
        Random rain = new Random();
        int probability = rain.nextInt(100);

        if (probability <= 5) {

            return Warning.HEAVY_RAIN;
        } else if (probability <= 15) {

            return Warning.WEAK_RAIN;
        } else {

            return Warning.NO_RAIN;
        }

    }


}
