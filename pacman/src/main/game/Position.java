package main.game;
public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] get(){
        int[] position = {x, y};
        return position;
    }

    public void set(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getXWithOffset(int offset){
        return x == 0 ? 0 : x * offset;
    }

    public static boolean  isEqual(Position position1, Position position2){
        return (position1.getX() == position2.getX() && position1.getY() == position2.getY());
    }

}
