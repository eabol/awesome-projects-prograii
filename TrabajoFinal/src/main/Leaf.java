package Main;

import java.util.Random;

public class Leaf extends Circumstances {

        public Leaf() {
        }
        public Warning succes(){
            Random leafPass= new Random();
            int probability=leafPass.nextInt(100);
            if(probability<=15){
                return Warning.FALL_LEAF;
            } else {
                return Warning.NO_FALL_LEAF;
            }
        }

    public void setDescription() {
        super.setDescription("The Snail ate a leaf");
    }
}
