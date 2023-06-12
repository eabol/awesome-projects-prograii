package Exception;

public class FullVacuumCleanerException {
	public class Main {
		public static void main(String[] args) {
			try {
				int bag = 50; // Capacidad actual de la bolsa de la aspiradora

				checkVacuumCleanerBag(bag);

				// Resto del código...
			} catch (FullVacuumCleanerException e) {
				System.out.println("Caught exception: " + e.getMessage());
			}
		}

		public static void checkVacuumCleanerBag(int bag) throws FullVacuumCleanerException {
			if (bag == 50) {
				throw new FullVacuumCleanerException("La aspiradora está llena");
			}
		}
	}

	class FullVacuumCleanerException extends Exception {
		public FullVacuumCleanerException(String message) {
			super(message);
		}
	}
}
