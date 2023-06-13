package vacuum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class VacuumCleanerTest {

	private VacuumCleaner vacuumCleaner;



	@Test
	public void testEmptyBag_bagNotEmpty() {


		// Capture the console output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		vacuumCleaner.emptyBag();

		// Assert that the bag has been emptied
		assertEquals(0, vacuumCleaner.getBag());
		assertEquals("The bag has been emptied", outputStream.toString().trim());
	}



	@Test
	public void testCheckBattery_batteryAboveZero() {
		vacuumCleaner.setCurrentBattery(10);

		// Capture the console output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		vacuumCleaner.checkBattery(vacuumCleaner);

		// Assert that the battery status is printed
		assertEquals("Battery left: 10/20", outputStream.toString().trim());
	}


	@Test
	public void testCheckCoordinates() {
		vacuumCleaner.setXCoordinate(3);
		vacuumCleaner.setYCoordinate(2);

		// Capture the console output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		vacuumCleaner.checkCoordinates(vacuumCleaner);

		// Assert that the expected message is printed
		assertEquals("Vacuum cleaner's current coordinates: 3,2", outputStream.toString().trim());
	}



	// Add more test cases as needed...
}

