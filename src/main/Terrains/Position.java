package src.main.Terrains;

public class Position {

    private int Xaxis;
    private int Yaxis;

    public int setPosition(int Xaxis, int Yaxis) {
        this.Xaxis = Xaxis;
        this.Yaxis = Yaxis;
        return 0;
    }

    public int[] getPosition(int Xaxis, int Yaxis) {
        int[] position = { Xaxis, Yaxis };
        return position;
    }
}
