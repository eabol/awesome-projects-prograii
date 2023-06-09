package main.utils;

import com.google.gson.Gson;
import main.core.Customer;
import main.core.data.Billing;
import main.core.Worker;
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
