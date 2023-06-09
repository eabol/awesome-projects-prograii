package Main;

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

    public void simulate() throws Alive, Death, FueraPozo {
        while (check()==State.ALIVE && Day.getDay()<50){
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
                    System.out.println("Car pass");
                    this.snail.setAltitude(this.snail.getAltitude()-2);
                }
                case CAR_NOT_PASS -> {
                }


            }
            switch (this.leaf.succes()){
                case FALL_LEAF -> {
                    System.out.println("Hoja cae");
                    this.snail.setAltitude(this.snail.getAltitude()+2);
                }
                case NO_FALL_LEAF -> {
                }

            }


            snail.rise();
            snail.drop();
            if(this.snail.getAltitude()>=0){
                throw new FueraPozo();
            }
            Day.nextDay();
            System.out.print("Water depth: "+well.getWaterDepth() + " / ");
            System.out.println("Snail position: "+snail.getAltitude());
            PrintSnail.dibujaPozo(-20,this.well.getWaterDepth(),this.snail.getAltitude(),this.car.succes(),this.leaf.succes());


        }
        if (snail.getState()==State.ALIVE){
            throw new Alive("The Snail survived");
        } else {
            throw new Death("The Snail died");
        }



    }
}

