public class Snail {

    private final String name="Paquillo";
    private int altitude =0;
    private Fatigue fatigue;

    public Snail() {
        fatigue=new Fatigue("The snail is tired");
        fallInHole();
    }

    public void fallInHole(){
       Tier n=new Tier();
        altitude =-n.getValue(10,20);
        System.out.println(name+" begin in the altitude "+altitude);
    }

    public int getAltitude() {
        return altitude;
    }
}
