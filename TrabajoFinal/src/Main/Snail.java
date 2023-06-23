package Main;

public class Snail {

    private final String name="Paquillo";
    private int altitude =0;
    private Fatigue fatigue;
    private State state;



    public Snail() {
        fatigue=new Fatigue();
        this.state=State.ALIVE;
        fallInHole();

    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public Snail(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }




    public void fallInHole(){
       Tier tier=new Tier();
        altitude =-tier.getValue(10,19);
        System.out.print(name+" begin in the altitude "+altitude);
    }

    public int getAltitude() {
        return altitude;
    }

    public void rise(){
        Tier tier=new Tier();
        int up=tier.getValue(1,fatigue.getSeverity(Day.getDay()));
        this.altitude +=up;
        System.out.print(name+" rise "+up+ " / ");
    }
    public void drop(){
        Tier tier=new Tier();
        int down=tier.getValue(0,2);
        this.altitude-=down;
        System.out.print(name+" drop "+ down + " / ");

    }

}
