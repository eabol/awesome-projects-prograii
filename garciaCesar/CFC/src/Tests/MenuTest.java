package Tests;

import Exceptions.OptionNotValidException;
import org.junit.Assert;
import org.junit.Test;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import Super.Menu;

public class MenuTest {

	@Test
	public void testSelectOption() {
		Menu menu = new Menu();
		ArrayList<String> options = getMenuOptions(menu);
		String expected = "1";
		InputStream in = new ByteArrayInputStream(expected.getBytes());
		System.setIn(in);
		int optionSelected;
		try {
			optionSelected = menu.selectOption();
			System.out.println("Opción esperada: " + expected);
			System.out.println("Opción seleccionada actual: " + optionSelected);
			Assert.assertEquals(Integer.parseInt(expected), optionSelected);
		} catch (OptionNotValidException e) {
			e.printStackTrace();
			Assert.fail("Excepción lanzada: OptionNotValidException");
		}
	}

	@Test(expected = OptionNotValidException.class)
	public void testSelectInvalidOption() throws OptionNotValidException {
		Menu menu = new Menu();
		String invalidOption = "9";
		InputStream in = new ByteArrayInputStream(invalidOption.getBytes());
		System.setIn(in);
		menu.selectOption();
	}

	private ArrayList<String> getMenuOptions(Menu menu) {
		try {
			Field optionsField = Menu.class.getDeclaredField("options");
			optionsField.setAccessible(true);
			return (ArrayList<String>) optionsField.get(menu);
		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}