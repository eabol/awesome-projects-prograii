package test.CORE;


import main.core.equipment.GasMater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GasMaterTest {

    private GasMater gasMater;
    @BeforeEach
    public void setup() {
        gasMater = new GasMater("GM-1", "Elster", "GC01006", "8432953036461", "Serie", 10, "PLCID");
    }
    @Test
    public void testGetIdGasMater() {

        Assertions.assertEquals("GM-1", gasMater.getIdGasMater());
    }

    @Test
    public void testSetIdGasMater() {
        gasMater.setIdGasMater("GM-2");
        Assertions.assertEquals("GM-2", gasMater.getIdGasMater());
    }

    @Test
    public void testGetBrand() {
        Assertions.assertEquals("Elster", gasMater.getBrand());
    }

    @Test
    public void testSetBrand() {
        gasMater.setBrand("Elster V2");
        Assertions.assertEquals("Elster V2", gasMater.getBrand());
    }

    @Test
    public void testGetRef() {
        Assertions.assertEquals("GC01006", gasMater.getRef());
    }

    @Test
    public void testSetRef() {
        gasMater.setRef("GC01007");
        Assertions.assertEquals("GC01007", gasMater.getRef());
    }

    @Test
    public void testGetEan13() {
        Assertions.assertEquals("8432953036461", gasMater.getEan13());
    }

    @Test
    public void testSetEan13() {
        gasMater.setEan13("New EAN13");
        Assertions.assertEquals("New EAN13", gasMater.getEan13());
    }

    @Test
    public void testGetSerie() {
        Assertions.assertEquals("Serie", gasMater.getSerie());
    }

    @Test
    public void testSetSerie() {
        gasMater.setSerie("New Serie");
        Assertions.assertEquals("New Serie", gasMater.getSerie());
    }

    @Test
    public void testGetPlcId() {
        Assertions.assertEquals("PLCID", gasMater.getPlcId());
    }

    @Test
    public void testSetPlcId() {
        gasMater.setPlcId("New PLCID");
        Assertions.assertEquals("New PLCID", gasMater.getPlcId());
    }

    @Test
    public void testToStringGasMater() {
        String expected = "GasMater{idGasMater='GM-1', brand='Elster', ref='GC01006', ean13='8432953036461', serie='Serie', readInstallationDay=10}";
        Assertions.assertEquals(expected, gasMater.toStringGasMater());
    }
}
