package test.CORE;

import main.core.data.Billing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BillingTest {

    private Billing billing;

    @BeforeEach
    public void setup() {
        billing = new Billing();
    }

    @Test
    public void testGetIdReport() {
        int expectedIdReport = 1;
        billing.setIdReport(expectedIdReport);
        int actualIdReport = billing.getIdReport();
        Assertions.assertEquals(expectedIdReport, actualIdReport);
    }

    @Test
    public void testGetIdCustomer() {
        String expectedIdCustomer = "72171365X";
        billing.setIdCustomer(expectedIdCustomer);
        String actualIdCustomer = billing.getIdCustomer();
        Assertions.assertEquals(expectedIdCustomer, actualIdCustomer);
    }

    @Test
    public void testGetIdGasMeter() {
        String expectedIdGasMeter = "GM-1";
        billing.setIdGasMeter(expectedIdGasMeter);
        String actualIdGasMeter = billing.getIdGasMeter();
        Assertions.assertEquals(expectedIdGasMeter, actualIdGasMeter);
    }

    @Test
    public void testGetIdPlc() {
        String expectedIdPlc = "PLC-001";
        billing.setIdPlc(expectedIdPlc);
        String actualIdPlc = billing.getIdPlc();
        Assertions.assertEquals(expectedIdPlc, actualIdPlc);
    }

    @Test
    public void testGetIdDataSim() {
        String expectedIdDataSim = "SIM-001";
        billing.setIdDataSim(expectedIdDataSim);
        String actualIdDataSim = billing.getIdDataSim();
        Assertions.assertEquals(expectedIdDataSim, actualIdDataSim);
    }

    @Test
    public void testGetFirstDate() {
        String expectedFirstDate = "01/01/2023";
        billing.setFirstDate(expectedFirstDate);
        String actualFirstDate = billing.getFirstDate();
        Assertions.assertEquals(expectedFirstDate, actualFirstDate);
    }

    @Test
    public void testGetSecondDate() {
        String expectedSecondDate = "28/01/2023";
        billing.setSecondDate(expectedSecondDate);
        String actualSecondDate = billing.getSecondDate();
        Assertions.assertEquals(expectedSecondDate, actualSecondDate);
    }

    @Test
    public void testGetFirstValue() {
        int expectedFirstValue = 100;
        billing.setFirstValue(expectedFirstValue);
        int actualFirstValue = billing.getFirstValue();
        Assertions.assertEquals(expectedFirstValue, actualFirstValue);
    }

    @Test
    public void testGetSecondValue() {
        int expectedSecondValue = 200;
        billing.setSecondValue(expectedSecondValue);
        int actualSecondValue = billing.getSecondValue();
        Assertions.assertEquals(expectedSecondValue, actualSecondValue);
    }
}
