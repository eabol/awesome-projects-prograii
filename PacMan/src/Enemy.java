public abstract class Enemy implements Movable,Droweable {

    int x;
    int y;

    @Override
    public void movement(PacMan pacman,Map map) {

    }

    boolean alive;

    public Enemy(int x,int y){
        this.x = x;
        this.y = y;
        this.alive = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }


}
