package test;

import main.core.equipment.GasMater;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GasMaterTest {

    @Test
    void getBrand (){

        GasMater gasMater1 = new GasMater();
        gasMater1.setBrand("Prueba");
        Assertions.assertEquals(gasMater1.getBrand(),"Prueba");
    }

    @Test
    void setIdGasMater (){

        GasMater gasmater1 = new GasMater();
        gasmater1.setIdGasMater("342");

        Assertions.assertEquals(gasmater1.getIdGasMater(),"342");
    }
}
