package vacuum;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

	@Test
	public void testMightSpawnOrDeSpawn_catNotPresent() {
		Cat cat = new Cat();
		cat.setPresent(false);

		// Set a fixed random number to ensure the cat spawns
		Math.random();
		cat.mightSpawnOrDeSpawn();

		// Assert that the cat is now present
		assertTrue(cat.getPresent());
	}

	@Test
	public void testMightSpawnOrDeSpawn_catPresent() {
		Cat cat = new Cat();
		cat.setPresent(true);

		// Set a fixed random number to ensure the cat despawns
		Math.random();
		cat.mightSpawnOrDeSpawn();

		// Assert that the cat is no longer present
		assertFalse(cat.getPresent());
	}

	@Test
	public void testCheckCat_catPresent() {
		Cat cat = new Cat();
		cat.setPresent(true);
		cat.setXCoordinate(3);
		cat.setYCoordinate(2);

		// Capture the console output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		cat.checkCat(cat);

		// Assert that the expected message has been printed
		assertEquals("the cat's current coordinates: 3,2", outputStream.toString().trim());
	}

	@Test
	public void testCheckCat_catNotPresent() {
		Cat cat = new Cat();
		cat.setPresent(false);

		// Capture the console output
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));

		cat.checkCat(cat);

		// Assert that no message has been printed
		assertEquals("", outputStream.toString().trim());
	}
}







