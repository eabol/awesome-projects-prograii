package Main;

import java.util.ArrayList;

public class World {
    private Well well;
    private Snail snail;
    private Rain rain;
    private Car car;
    private Leaf leaf;


    public World() {
        this.well = new Well();
        this.snail = new Snail();
        this.rain =new Rain();
        this.car = new Car();
        this.leaf = new Leaf();
    }

    public State check(){
        if(this.well.getWaterDepth()<this.snail.getAltitude()&& Day.getDay()<50){
            this.snail.setState(State.ALIVE);
            return State.ALIVE;
        }else{
            this.snail.setState(State.DEATH);
            return State.DEATH;
        }
    }

    public void simulate() throws Alive, Death, CameOut {
        ArrayList<Warning> warnings=new ArrayList<>();
        while (check()==State.ALIVE && Day.getDay()<50){
            warnings=new ArrayList<>();
            System.out.println("");
            System.out.println("");
            System.out.println("Day "+Day.getDay());

           switch (this.rain.succes()){
                case HEAVY_RAIN -> {
                    System.out.println("Heavy rain");
                    this.well.setWaterDepth(this.well.getWaterDepth()+5);
                }
                case WEAK_RAIN -> {
                    System.out.println("Weak rain");
                    this.well.setWaterDepth(this.well.getWaterDepth()+2);
                }
                case NO_RAIN -> {
                }
            }

            switch (this.car.succes()){
                case CAR_PASS -> {
                    System.out.println("Car pass [-2]");
                    this.snail.setAltitude(this.snail.getAltitude()-2);
                    warnings.add(Warning.CAR_PASS);
                }
                case CAR_NOT_PASS -> {
                }


            }
            switch (this.leaf.succes()){
                case FALL_LEAF -> {
                    System.out.println("The snail ate a leaf [+1]");
                    this.snail.setAltitude(this.snail.getAltitude()+1);
                    warnings.add(Warning.FALL_LEAF);
                }
                case NO_FALL_LEAF -> {
                }

            }


            snail.rise();
            snail.drop();
            if(this.snail.getAltitude()>=0){
                throw new CameOut();
            }
            System.out.print("Water depth ["+well.getWaterDepth() + "] / ");
            System.out.println("Snail position ["+snail.getAltitude()+" ]");
            printWell(warnings);
            Day.nextDay();



        }
        if (snail.getState()==State.ALIVE){
            throw new Alive();
        } else {
            throw new Death();
        }



    }

    public void printWell(ArrayList<Warning> warnings) {
        for (int i = 0; i >= -20; i=i-1) {
            if(i==0 && warnings.indexOf(Warning.CAR_PASS)>=0){
                System.out.println("  []    O-=-O     []");
            }else if (i == 0) {
                System.out.println("  []              []");
            } else if (i <= this.well.getWaterDepth()) {
                System.out.println("  []~~~~~~~~~~~~~~[]" + i);
            } else if (i == this.snail.getAltitude() && warnings.indexOf(Warning.FALL_LEAF)>=0) {
                System.out.println("  []    _@)_/’  * []" + i);
            } else if (i == this.snail.getAltitude()) {
                System.out.println("  []    _@)_/’    []" + i);
            } else {
                System.out.println("  []:. :. :. :. :.[]" + i);
            }
        }
        System.out.println("  [][][][][][][][][] ");
        System.out.println("\n");
    }
}

