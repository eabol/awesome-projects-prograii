package Exception;

public class playerException {
	public class Main {
		public class Main {
			public static void main(String[] args) {
				try {
					int buttonClicked = 9; // Supongamos que el valor del botón presionado es 9
					processButtonClick(buttonClicked);
				} catch (ValueOutOfRangeException e) {
					System.out.println("Caught exception: " + e.getMessage());
				}
			}

			public static void processButtonClick(int buttonClicked) throws ValueOutOfRangeException {
				if (buttonClicked >= 0 && buttonClicked <= 8) {
					System.out.println("Botón correcto: " + buttonClicked);
				} else {
					throw new ValueOutOfRangeException();
				}
			}
		}

		class ValueOutOfRangeException extends Exception {
			public ValorFueraDeRangoException() {
				super("El valor del botón está fuera del rango permitido (0-8)");
			}
		}


	}

}
