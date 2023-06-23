package test.utils;

import main.utils.DateValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DateValidatorTest {

    private DateValidator dateValidator;

    @BeforeEach
    public void setup() {
        dateValidator = new DateValidator("dd/MM/yyyy");
    }

    @Test
    public void isValidDate() {

        String validDate = "01/01/2023";
        boolean isValid = dateValidator.isValid(validDate);
        Assertions.assertTrue(isValid);
    }

    @Test
    public void isInvalidDate() {

        String invalidDate = "invalid-invalid-invalid";
        boolean isValid = dateValidator.isValid(invalidDate);
        Assertions.assertFalse(isValid);
    }

    @Test
    public void dateFormat() {

        String date = "01/01/2023";
        String[] result = dateValidator.dateFormat(date);
        Assertions.assertEquals(3, result.length);
    }
}
