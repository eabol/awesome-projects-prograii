public abstract class Point {

    protected int x;
    protected int y;
    public int value;
    protected boolean eaten;

    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
        this.eaten = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    public boolean isEaten() {
        return eaten;
    }

    public void setEaten(boolean eaten) {
        this.eaten = eaten;
    }
}
