package main.utils;

import main.core.data.Customer;
import main.core.data.Billing;
import main.core.data.Worker;
import main.core.data.Prices;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;

import java.io.IOException;

public interface Writer {
    void writeBillingData(Billing bill) throws IOException;
    void writeCustomerData(Customer customer) throws IOException;
    void writeSimData(DataSim sim) throws IOException;
    void writeGasMeterData(GasMater gas) throws IOException;
    void writePLCData(Plc plc) throws IOException;
    void writeWorkersData(Worker employee) throws IOException;
    void writePriceData(Prices price) throws IOException;
}
