package main.utils;

import main.core.*;
import main.core.data.Billing;
import main.core.data.Prices;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;

import java.util.List;

public interface Parser {
    List<Billing> billingData();
    List<Customer> customerData();
    List<DataSim> simData();
    List<GasMater> gasMaterData();
    List<Plc> plcData();
    List<Worker> workerData();
    List<Prices> pricesData();
}