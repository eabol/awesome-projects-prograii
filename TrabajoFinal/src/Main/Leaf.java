package Main;

import java.util.Random;

public class Leaf {

        public Leaf() {
        }
        public Warning succes(){
            Random r= new Random();
            int probability=r.nextInt(100);
            if(probability<=70){
                return Warning.FALL_LEAF;
            }else {
                return Warning.NO_FALL_LEAF;
            }
        }
    }
