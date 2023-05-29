public class Movement {

    public static void nextDay(){
        rise();
        drop();
        if(car.succes()){
            altitude=altitude-2;
        }
        System.out.println(altitude);
        day++;

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
}
