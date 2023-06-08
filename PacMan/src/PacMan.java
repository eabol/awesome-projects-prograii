public class PacMan implements Droweable, Movable {

    int x;
    int y;

    public PacMan(){

    }
    @Override
    public void Draw() {

    }

    @Override
    public void movement(String movimiento) {
        if(movimiento.equalsIgnoreCase("w")||movimiento.equals("8")){
            this.y=y++;
        } else if (movimiento.equalsIgnoreCase("a")||movimiento.equals("4")) {
            this.x=x--;
        } else if (movimiento.equalsIgnoreCase("s")||movimiento.equals("2")) {
            this.y=y--;
        } else if (movimiento.equalsIgnoreCase("d")||movimiento.equals("6")) {
            this.x=x++;
        }

    }

    @Override
    public void movement() {

    }
}
