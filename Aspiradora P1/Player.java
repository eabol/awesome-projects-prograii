public class Player {
	private int direction;
	private int x;
	private int y;

	public Player(int initialX, int initialY) {
		this.direction = 0;
		this.x = initialX;
		this.y = initialY;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int newDirection) {
		direction = newDirection;
	}
}
