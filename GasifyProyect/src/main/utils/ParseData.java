package main.utils;

import com.google.gson.Gson;
import main.core.data.Billing;
import main.core.data.Customer;
import main.core.data.Prices;
import main.core.data.Worker;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public abstract class ParseData extends FileReader implements Parser {


    private Gson gson;
    private String data;
    public ParseData(){
        gson = new Gson();
    }

    /*
    #########################################################
    Class to collect JSON files and parse them into an array,
    the information is parameterized based on the classes in the Core folder.
    @@ URL: https://stackoverflow.com/questions/35034367/convert-json-array-to-java-class-object-list
    #################################################################################################
    */
    public List<Billing> billingData() {

        data = null;
        List<Billing> billingToDate;

        try {
            data = readAsString("./src/main/data/json/CustomerBilling.json");
            billingToDate = Arrays.asList(gson.fromJson(data, Billing[].class));
            return billingToDate;

        } catch (IOException e) {
            System.err.println("CustomerBilling.json not found!");
        }
        return null;
    }

    public List<Customer> customerData() {

        data = null;
        List<Customer> allCustomers;

        try {
            data = readAsString("./src/main/data/json/customers.json");
            allCustomers = Arrays.asList(gson.fromJson(data, Customer[].class));
            return allCustomers;

        } catch (IOException e){
            System.err.println("Customer.json not found!");
        }
        return null;
    }

    public List<DataSim> simData() {

        data = null;
        List<DataSim> allDataSims;

        try {
            data = readAsString("./src/main/data/json/dataSims.json");
            allDataSims = Arrays.asList(gson.fromJson(data, DataSim[].class));
            return allDataSims;
        }catch(IOException e){
            System.err.println("dataSims.json not found!");
        }
        return null;
    }

    public List<GasMater> gasMaterData() {

        data = null;
        List<GasMater> allGasMater;

        try {
            data = readAsString("./src/main/data/json/gasMaters.json");
            allGasMater = Arrays.asList(gson.fromJson(data, GasMater[].class));
            return allGasMater;
        }catch(IOException e){
            System.err.println("gasMaters.json not found!");
        }
        return null;
    }

    public List<Plc> plcData() {

        data = null;
        List<Plc> allPlc;

        try {
            data = readAsString("./src/main/data/json/Plcs.json");
            allPlc = Arrays.asList(gson.fromJson(data, Plc[].class));
            return allPlc;
        }catch(IOException e) {
            System.out.println("Plcs.json not found!");
        }
        return null;
    }

    public List<Worker> workerData() {

        data = null;
        List<Worker> allWorkers;

        try {
            data = readAsString("./src/main/data/json/workers.json");
            allWorkers = Arrays.asList(gson.fromJson(data, Worker[].class));
            return allWorkers;
        } catch(IOException e) {
            System.err.println("workers.json not found!");
        }
        return null;
    }

    public List<Prices> pricesData() {

        data = null;
        List<Prices> allPrices;

        try {
            data = readAsString("./src/main/data/json/Prices.json");
            allPrices = Arrays.asList(gson.fromJson(data, Prices[].class));
            return allPrices;
        }catch(IOException e){
            System.err.println("Prices.json not found!");
        }
        return null;

    }
}
