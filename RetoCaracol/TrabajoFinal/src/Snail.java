public class Snail {
    public int day=1;

    private final String name="Paquillo";
    private int altitude =0;

    public Snail() {
        fallInHole();
    }

    public void fallInHole(){
       tier n=new tier();
        altitude = n.getValue(10,20);
    }
    private void rise(){
        tier n=new tier();
        this.altitude =n.getValue(1,Fatigue.getSeverity(day));

    }
    private void drop(){
        tier n=new tier();
        this.altitude-=-n.getValue(0,2);
    }
    public void nextDay(){
        rise();
        drop();
        if(Car.succes()){
            altitude=altitude-2;
        }
        day++;

    }

    public int getAltitude() {
        return altitude;
    }
}
