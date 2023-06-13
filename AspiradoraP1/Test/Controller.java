package vacuum;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class ControllerTest {

	@Test
	public void testGameKeys_toggleAutomatedMode() {
		VacuumCleaner P1 = new VacuumCleaner();
		P1.setAutomated(false);

		// Simulate 'r' key input
		boolean automatedMode = Controller.gameKeys('r', P1);

		// Assert that the automated mode has been toggled
		assertTrue(automatedMode);
	}

	@Test
	public void testGameKeys_finishGame() {
		VacuumCleaner P1 = new VacuumCleaner();

		// Simulate 'f' key input
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		Controller.gameKeys('f', P1);

		// Assert that the expected message has been printed
		assertEquals("El juego terminará", outputStream.toString().trim());
	}

	@Test
	public void testGameKeys_emptyBag() {
		VacuumCleaner P1 = new VacuumCleaner();
		P1.addItemToBag(new Item());

		// Simulate 'e' key input
		Controller.gameKeys('e', P1);

		// Assert that the bag is empty
		assertEquals(0, P1.getBagItems());
	}

	@Test
	public void testGameKeys_manualMovement() {
		VacuumCleaner P1 = new VacuumCleaner();
		P1.setAutomated(false);

		// Simulate 'm' key input
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		Controller.gameKeys('m', P1);

		// Assert that the expected message has been printed
		assertEquals("Movimiento manual", outputStream.toString().trim());
	}
}



