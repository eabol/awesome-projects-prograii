public class Snail {
    public int day=1;

    private final String name="Paquillo";
    private int altitude =0;
    private Fatigue fatigue;
    private Car car;
    public Snail() {
        fatigue=new Fatigue("The snail is tired");
        car=new Car("The car passed");

        fallInHole();
    }

    public void fallInHole(){
       Tier n=new Tier();
        altitude =-n.getValue(10,20);
        System.out.println(name+" begin in the altitude "+altitude);
    }
    private void rise(){
        Tier n=new Tier();
        int up=n.getValue(1,fatigue.getSeverity(day));
        this.altitude +=up;
        System.out.println(name+" rise "+up+" and is in the altitude "+altitude);
    }
    private void drop(){
        Tier n=new Tier();
        int down=-n.getValue(0,2);
        this.altitude-=down;
        System.out.println(name+" drop "+ down);

    }
    public void nextDay(){
        rise();
        drop();
        if(car.succes()){
            altitude=altitude-2;
        }
        System.out.println(altitude);
        day++;

    }


    public int getAltitude() {
        return altitude;
    }
}
