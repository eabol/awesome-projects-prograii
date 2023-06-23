package test.CORE;

import main.core.equipment.Plc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PLCTest {

    private Plc plc;

    @BeforeEach
    public void setup() {
        plc = new Plc("PLC-01", "Siemens", "S7-1200", "SIM-001");
    }
    @Test
    public void testGetIdPlc() {
        Assertions.assertEquals("PLC-01", plc.getIdPlc());
    }

    @Test
    public void testSetIdPlc() {
        plc.setIdPlc("PLC-02");
        Assertions.assertEquals("PLC-02", plc.getIdPlc());
    }

    @Test
    public void testGetMaker() {
        Assertions.assertEquals("Siemens", plc.getMaker());
    }

    @Test
    public void testSetMaker() {
        plc.setMaker("Siemens V2");
        Assertions.assertEquals("Siemens V2", plc.getMaker());
    }

    @Test
    public void testGetModel() {
        Assertions.assertEquals("S7-1200", plc.getModel());
    }

    @Test
    public void testSetModel() {
        plc.setModel("S7-1250");
        Assertions.assertEquals("S7-1250", plc.getModel());
    }

    @Test
    public void testGetSimDataId() {
        Assertions.assertEquals("SIM-001", plc.getSimDataId());
    }

    @Test
    public void testSetSimDataId() {
        plc.setSimDataId("SIM-002");
        Assertions.assertEquals("SIM-002", plc.getSimDataId());
    }

    @Test
    public void testToStringPlc() {
        String expected = "Plc{idPlc='PLC-01', maker='Siemens', model='S7-1200'}";
        Assertions.assertEquals(expected, plc.toStringPlc());
    }
}
