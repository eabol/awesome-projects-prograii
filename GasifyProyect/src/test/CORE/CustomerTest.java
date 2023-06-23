package test.CORE;

import main.core.data.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    private Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer();
    }

    @Test
    public void testSetNameCustomer() {

        String expectedName = "Cayetano";
        customer.setNameCustomer(expectedName);
        String actualName = customer.getNameCustomer();
        Assertions.assertEquals(expectedName, actualName);

    }

    @Test
    public void testGetIdCustomer() {

        String expectedId = "72171365X";
        customer.setIdCustomer(expectedId);
        String actualId = customer.getIdCustomer();
        Assertions.assertEquals(expectedId, actualId);

    }

    @Test
    public void testGetNumberPhone() {
        String expectedNumberPhone = "123-456-7890";
        customer.setNumberPhone(expectedNumberPhone);
        String actualNumberPhone = customer.getNumberPhone();
        Assertions.assertEquals(expectedNumberPhone, actualNumberPhone);
    }

    @Test
    public void testGetAddress() {
        String expectedAddress = "123 Uneatlantico";
        customer.setAddress(expectedAddress);
        String actualAddress = customer.getAddress();
        Assertions.assertEquals(expectedAddress, actualAddress);
    }

    @Test
    public void testGetPlcId() {
        String expectedPlcId = "PLC-01";
        customer.setPlcId(expectedPlcId);
        String actualPlcId = customer.getPlcId();
        Assertions.assertEquals(expectedPlcId, actualPlcId);
    }

    @Test
    public void testGetSimId() {
        String expectedSimId = "SIM-001";
        customer.setSimId(expectedSimId);
        String actualSimId = customer.getSimId();
        Assertions.assertEquals(expectedSimId, actualSimId);
    }

    @Test
    public void testGetGasMaterID() {

        String expectedGasMeterId = "GM-1";
        customer.setGasMaterID(expectedGasMeterId);
        String actualGasMeterId = customer.getGasMaterID();
        Assertions.assertEquals(expectedGasMeterId, actualGasMeterId);

    }

    @Test
    public void testToString() {

        String expectedToString = "Customer{idCustomer='72171365X', nameCustomer='Elder Bol', numberPhone='123-456-7890', address='123 Uneatlantico'}";
        customer.setIdCustomer("72171365X");
        customer.setNameCustomer("Elder Bol");
        customer.setNumberPhone("123-456-7890");
        customer.setAddress("123 Uneatlantico");
        String actualToString = customer.toString();
        Assertions.assertEquals(expectedToString, actualToString);

    }
}