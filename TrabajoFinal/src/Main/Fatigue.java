package Main;

public class Fatigue{
    public Fatigue() {
    }

    public int getSeverity(int day) {
        if (day<=10){
            return 4;
        }else if (day<=20){
            return 3;
        }else{
            return 2;
        }
    }
}
