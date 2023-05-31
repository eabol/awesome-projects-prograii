package Main;

public class Fatigue extends Problem {
    public Fatigue(String description) {
        super(description);
    }

    public int getSeverity(int day) {
        if (day<=10){
            System.out.println("Primeros 10 dias");
            return 4;
        }else if (day<=20){
            System.out.println("Primeros 20 dias");
            return 3;
        }else{
            System.out.println("Primeros 50 dias");
            return 2;
        }
    }
}
