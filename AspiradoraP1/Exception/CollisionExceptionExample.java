package Exception;

public class CollisionExceptionExample extends Exception {
	public static void main(String[] args) {
		try {
			checkCollision(10, 20);
			System.out.println("No Collision detected.");
		} catch (CollisionException e) {
			System.out.println("Error: Collision in Coordinates:(" + e.getX() + ", " + e.getY() + ").");
		}
	}

	public static void checkCollision(int x, int y) throws CollisionException {
	      		boolean collisionDetected = false;

		if (collisionDetected) {
			throw new CollisionException(x, y);
		}
	}
}

class CollisionException extends Exception {
	private int x;
	private int y;

	public CollisionException(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}