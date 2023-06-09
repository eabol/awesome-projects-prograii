package test;

import main.core.equipment.DataSim;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataSimTest {


    @Test
    void toStringDataSim (){


        DataSim dataSim1 = new DataSim("ABC123", "987654321", "MyService");

        String expected = "DataSim{idDataSim='ABC123', numberDataSim='987654321', serviceCompany='MyService'}";


        Assertions.assertEquals(expected, dataSim1.toStringDataSim());

    }

    @Test
    void setNumber (){

        DataSim dataSim1 = new DataSim("ABC123", "987654321", "MyService");

        dataSim1.setNumberDataSim("942341484");

        Assertions.assertEquals(dataSim1.getNumberDataSim(), "942341484");


    }
}
