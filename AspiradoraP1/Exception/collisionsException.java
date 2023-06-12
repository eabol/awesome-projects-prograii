package Exception;

public class collisionsException {

	public class Main {
		public class Main {
			public static void evaluateVacuumPosition(int vacuumPosition) throws CollisionException {
				int sofaPosition = 7; // Posición del sofá
				int tablePosition = 10; // Posición de la mesa

				if (vacuumPosition == sofaPosition || vacuumPosition == tablePosition) {
					throw new CollisionException("Collision with the sofa or table");
				}
				System.out.println("No collision detected");
			}
		}

		class CollisionException extends Exception {
			public CollisionException(String message) {
				super(message);
			}
		}





}
