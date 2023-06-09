package main.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import main.core.Customer;
import main.core.data.Billing;
import main.core.Worker;
import main.core.data.Prices;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class FileWriter extends FileReader implements Writer{

    private Gson gson;
    private String data;
    private java.io.FileWriter writer;

    public FileWriter() {
        gson = new Gson();
    }

    public void writeBillingData(Billing bill) {
        String path = "./src/main/data/json/CustomerBilling.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<Billing> bills =  new ArrayList<>(Arrays.asList(gson.fromJson(data, Billing[].class)));
            bills.add(bill);
            writer  = new java.io.FileWriter(path);
            gson.toJson(bills, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("CustomerBilling.json not found!");
        }
    }

    public void writeCustomerData(Customer customer) {
        String path = "./src/main/data/json/customers.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<Customer> customers =  new ArrayList<>(Arrays.asList(gson.fromJson(data, Customer[].class)));
            customers.add(customer);
            writer  = new java.io.FileWriter(path);
            gson.toJson(customers, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Customer.json not found!");
        }
    }

    public void writeSimData(DataSim sim) {
        String path = "./src/main/data/json/dataSims.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<DataSim> sims =  new ArrayList<>(Arrays.asList(gson.fromJson(data, DataSim[].class)));
            sims.add(sim);
            writer  = new java.io.FileWriter(path);
            gson.toJson(sims, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("dataSims.json not found!");
        }
    }

    public void writeGasMeterData(GasMater gas) {
        String path = "./src/main/data/json/gasMaters.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<GasMater> meters =  new ArrayList<>(Arrays.asList(gson.fromJson(data, GasMater[].class)));
            meters.add(gas);
            writer  = new java.io.FileWriter(path);
            gson.toJson(meters, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("gasMaters.json not found!");
        }
    }

    public void writePLCData(Plc plc) {
        String path = "./src/main/data/json/Plcs.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<Plc> plcs =  new ArrayList<>(Arrays.asList(gson.fromJson(data, Plc[].class)));
            plcs.add(plc);
            writer  = new java.io.FileWriter(path);
            gson.toJson(plcs, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Plcs.json not found!");
        }
    }

    public void writeWorkersData(Worker employee) {
        String path = "./src/main/data/json/workers.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<Worker> work = new ArrayList<>(Arrays.asList(gson.fromJson(data, Worker[].class)));
            work.add(employee);
            writer  = new java.io.FileWriter(path);
            gson.toJson(work, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("workers.json not found!");
        }
    }

    public void writePriceData(Prices price) {
        String path = "./src/main/data/json/Prices.json";
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();
            data = readAsString(path);
            List<Prices> prices =  new ArrayList<>(Arrays.asList(gson.fromJson(data, Prices[].class)));
            prices.add(price);
            writer  = new java.io.FileWriter(path);
            gson.toJson(prices, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Prices.json not found!");
        }

    }

}
