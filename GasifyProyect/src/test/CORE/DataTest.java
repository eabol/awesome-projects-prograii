package test.CORE;

import main.core.data.Customer;
import main.core.data.Worker;
import main.core.data.Billing;
import main.core.data.Data;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DataTest {

    private Data data;

    @BeforeEach
    public void setup() {
        data = new Data();
    }

    @Test
    public void testFindWorkerByID() {
        String id = "EMP-48327";
        List<Worker> workers = data.findWorkerByID(id);
        Assertions.assertNotNull(workers);
    }

    @Test
    public void testFindWorkerByUser() {
        String user = "Pedro";
        List<Worker> workers = data.findWorkerByUser(user);
        Assertions.assertNotNull(workers);
    }

    @Test
    public void testFindWorkerByEmail() {
        String email = "tecnico1@gmail.com";
        List<Worker> workers = data.findWorkerByEmail(email);
        Assertions.assertNotNull(workers);
    }

    @Test
    public void testFindPriceByDate() {
        String period = "01/2023";
        float price = data.findPriceByDate(period);
        Assertions.assertNotEquals(-1, price);
    }

    @Test
    public void testFindBillingByUser() {
        String customerId = "72171365X";
        List<Billing> billings = data.findBillingByUser(customerId);
        Assertions.assertNotNull(billings);
    }

    @Test
    public void testFindGasMeter() {
        String gasMeterId = "GM-1";
        List<GasMater> gasMeters = data.findGasMeter(gasMeterId);
        Assertions.assertNotNull(gasMeters);
    }

    @Test
    public void testFindSim() {
        String simId = "SIM-001";
        List<DataSim> simData = data.findSim(simId);
        Assertions.assertNotNull(simData);
    }

    @Test
    public void testFindPlc() {
        String plcId = "PLC-01";
        List<Plc> plcData = data.findPlc(plcId);
        Assertions.assertNotNull(plcData);
    }

    @Test
    public void testFindCustomerByName() {
        String name = "Daniel";
        List<Customer> customers = data.findCustomerByName(name);
        Assertions.assertNotNull(customers);
    }

    @Test
    public void testFindCustomerByID() {
        String id = "72171365X";
        List<Customer> customers = data.findCustomerByID(id);
        Assertions.assertNotNull(customers);
    }

    @Test
    public void testFindCustomerByNumber() {
        String numberPhone = "687220274";
        List<Customer> customers = data.findCustomerByNumber(numberPhone);
        Assertions.assertNotNull(customers);
    }
}
