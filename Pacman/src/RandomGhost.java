import java.util.Random;

public class RandomGhost extends Ghost {
    private Random random;
public RandomGhost(int x, int y) {
        super(x, y);
        random = new Random();
        }
@Override
public void movement(PacMan pacman,Map map) {
        int direction = random.nextInt(4);

        if (direction == 0) {
        if (!map.isWall(this.x + 1, this.y))
        this.x++;  // Mover a la derecha
        } else if (direction == 1) {
        if (!map.isWall(this.x - 1, this.y))
        this.x--;  // Mover a la izquierda
        } else if (direction == 2) {
        if (!map.isWall(this.x, this.y + 1))
        this.y++;  // Mover hacia abajo
        } else if (direction == 3) {
        if (!map.isWall(this.x, this.y - 1))
        this.y--;  // Mover hacia arriba
        }
        }


    @Override
    public void movement(String movimiento) {

    }
}