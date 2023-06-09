package test.CORE;

import main.core.equipment.DataSim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSimTest {

    @Test
    public void testGetIdDataSim() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        Assertions.assertEquals("SIM-001", dataSim.getIdDataSim());
    }

    @Test
    public void testSetIdDataSim() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        dataSim.setIdDataSim("SIM-002");
        Assertions.assertEquals("SIM-002", dataSim.getIdDataSim());
    }

    @Test
    public void testGetNumberDataSim() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        Assertions.assertEquals("687493284", dataSim.getNumberDataSim());
    }

    @Test
    public void testSetNumberDataSim() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        dataSim.setNumberDataSim("0000");
        Assertions.assertEquals("0000", dataSim.getNumberDataSim());
    }

    @Test
    public void testGetServiceCompany() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        Assertions.assertEquals("Digi", dataSim.getServiceCompany());
    }

    @Test
    public void testSetServiceCompany() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        dataSim.setServiceCompany("Vodafone");
        Assertions.assertEquals("Vodafone", dataSim.getServiceCompany());
    }

    @Test
    public void testToStringDataSim() {
        DataSim dataSim = new DataSim("SIM-001", "687493284", "Digi");
        String expected = "DataSim{idDataSim='SIM-001', numberDataSim='687493284', serviceCompany='Digi'}";
        Assertions.assertEquals(expected, dataSim.toStringDataSim());
    }
}
