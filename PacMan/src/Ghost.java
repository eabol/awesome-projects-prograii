public abstract class Ghost extends Enemy implements Droweable, Movable {
    public Ghost(int x, int y) {
        super(x, y);
    }


    @Override
    public void move(PacMan pacman, Map map) {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();

        // calcular las distancias para cada movimiento posible
        int distMoveRight = Math.abs((this.x+1) - pacmanX) + Math.abs(this.y - pacmanY);
        int distMoveLeft = Math.abs((this.x-1) - pacmanX) + Math.abs(this.y - pacmanY);
        int distMoveUp = Math.abs(this.x - pacmanX) + Math.abs((this.y-1) - pacmanY);
        int distMoveDown = Math.abs(this.x - pacmanX) + Math.abs((this.y+1) - pacmanY);

        // encontrar el movimiento que minimiza la distancia
        int minDist = Math.min(Math.min(distMoveRight, distMoveLeft), Math.min(distMoveUp, distMoveDown));

        if (minDist == distMoveRight) {
            if (!map.isWall(this.x + 1, this.y))
                this.x++;
        } else if (minDist == distMoveLeft) {
            if (!map.isWall(this.x - 1, this.y))
                this.x--;
        } else if (minDist == distMoveUp) {
            if (!map.isWall(this.x, this.y - 1))
                this.y--;
        } else if (minDist == distMoveDown) {
            if (!map.isWall(this.x, this.y + 1))
                this.y++;
        }
    }

    @Override
    public void Draw(Map map) {
        map.grid[this.x][this.y]= 4;
    }

}
