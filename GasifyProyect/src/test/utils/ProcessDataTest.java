package test.utils;

import main.core.data.Billing;
import main.utils.ProcessData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessDataTest {

    /*
    * Bill report *

     {
    "idReport": 5,
    "idCustomer": "72171365X",
    "idGasMeter": "GM-1",
    "idPlc": "PLC-01",
    "idDataSim": "SIM-001",
    "firstDate": "01/05/2023",
    "secondDate": "28/05/2023",
    "firstValue": 140,
    "secondValue": 153
     }

     * Price date *

     {
     "year": 2023,
     "period": "01/05/2023",
     "value": 0.04525892308
     }
     */

    @Test
    @DisplayName("Search for a specific bill.")
    void findSpecificMonthBill (){

        ProcessData data = new ProcessData();
        List<Billing> result = data.findSpecificMonthBill("72171365X","05/2023");
        String resultId = result.get(0).getIdCustomer();
        String resultFirstDate = result.get(0).getFirstDate();
        assertTrue(resultId.equals("72171365X") && resultFirstDate.equals("01/05/2023"));
    }

    @Test
    @DisplayName("Price calculation.")
    void priceCalc (){

        float expectedPrice = (float) (((153 - 140) * 11.7) * 0.04525892308) + 12;

        ProcessData data = new ProcessData();
        float result = data.priceCalc("72171365X","05/2023");
        assertEquals(expectedPrice, result);
    }

    @Test
    @DisplayName("The difference between two values")
    void diffValuesTest (){
        ProcessData data = new ProcessData();
        float result = data.diffValues("72171365X","05/2023");
        assertEquals(153-140, result);
    }
}
