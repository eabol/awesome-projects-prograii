public class PacMan implements Droweable, Movable {

    public int x;
    public int y;

    private int score;

    public PacMan(){
        this.x=14;
        this.y=22;
    }

    public void eat(Food food){
        if(!food.isEaten()){
            food.setEaten(true);
            this.score+= food.getValue();
        }
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

    @Override
    public void movement(String movimiento,Map map) {
        if(movimiento.equalsIgnoreCase("w")||movimiento.equals("8")){
            if (!map.isWall(this.x, this.y - 1))
                this.y--;
        } else if (movimiento.equalsIgnoreCase("a")||movimiento.equals("4")) {
            if (!map.isWall(this.x - 1, this.y))
                this.x--;
        } else if (movimiento.equalsIgnoreCase("s")||movimiento.equals("2")) {
            if (!map.isWall(this.x, this.y + 1))
                this.y++;
        } else if (movimiento.equalsIgnoreCase("d")||movimiento.equals("6")) {
            if (!map.isWall(this.x + 1, this.y))
                this.x++;
        }

    }

    @Override
    public void movement(PacMan pacman,Map map) {

    }


    @Override
    public void Draw() {
        System.out.print("(º)");
    }

}
