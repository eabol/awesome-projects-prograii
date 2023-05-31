package Main;

public class World {
    private Well well;
    private Snail snail;
    private Rain rain;
    private Car car;

    public World() {
        this.well = new Well();
        this.snail = new Snail();
        this.rain =new Rain();
        this.car = new Car();
    }

    public State check(){
        if(this.well.getWaterDepth()<this.snail.getAltitude()||Day.getDay()<50){
            this.snail.setState(State.ALIVE);
            return State.ALIVE;
        }else{
            this.snail.setState(State.DEATH);
            return State.DEATH;
        }
    }

    public void simulate(){
        while (check()==State.ALIVE){
            System.out.println("Day "+Day.getDay());
            System.out.println("Main.Snail position: "+snail.getAltitude());

            switch (this.rain.succes()){
                case HEAVY_RAIN -> {
                    System.out.println("Main.Rain: Heavy rain");
                    this.well.setWaterDepth(this.well.getWaterDepth()+5);
                }
                case WEAK_RAIN -> {
                    System.out.println("Main.Rain: Weak rain");
                    this.well.setWaterDepth(this.well.getWaterDepth()+2);
                }
                case NO_RAIN -> {
                    System.out.println("Main.Rain: No rain");
                    ;
                }
            }

            switch (this.car.succes()){
                case CAR_PASS -> {
                    System.out.println("Main.Car: Car pass");
                    this.snail.setAltitude(this.snail.getAltitude()-2);
                }
                case CAR_NOT_PASS -> {
                    System.out.println("Main.Car: Car not pass");
                }

            }

            snail.rise();
            snail.drop();
            Day.nextDay();



            System.out.println("Main.Rain position: "+rain.getPosition());
            System.out.println("Main.Car position: "+car.getPosition());
            System.out.println();
            snail.move();
            well.update();
            rain.update();
            car.update();
            day.nextDay();
        }
        if (snail.isAlive()){
            System.out.println("The Main.Snail survived ");
        } else {
            System.out.println("The Main.Snail died");
        }

    }
}
}
