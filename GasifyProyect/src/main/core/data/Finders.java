package main.core.data;

import main.core.Customer;
import main.core.Worker;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;

import java.util.List;

public interface Finders {
    List<DataSim> findSimDataByID(String customerId);
    List<Worker> findWorkerByID(String id);
    List<Worker> findWorkerByUser(String user);
    List<Worker> findWorkerByEmail(String email);
    float findPriceByDate(String period);
    List<Billing> findBillingByUser(String customerID);
    List<GasMater> findGasMeter(String gasMeterId);
    List<DataSim> findSim(String simId);
    List<Plc> findPlc(String plcId);
    List<Customer> findCustomerByName(String name);
    List<Customer> findCustomerByID(String ID);
    List<Customer> findCustomerByNumber(String numberPhone);
}