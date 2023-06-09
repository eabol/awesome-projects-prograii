package main.core.data;

import main.core.Customer;
import main.core.Worker;
import main.core.equipment.DataSim;
import main.core.equipment.GasMater;
import main.core.equipment.Plc;
import main.utils.DateValidator;
import main.utils.ParseData;

import java.util.ArrayList;
import java.util.List;

public class Data extends ParseData implements Finders {

    DateValidator fullDate;
    DateValidator monthYear;
    DateValidator format;

    public Data() {
        fullDate = new DateValidator("dd/MM/yyyy");
        monthYear = new DateValidator("MM/yyyy");
    }

    public List<DataSim> findSimDataByID(String customerId) {

        List <Customer> customer = findCustomerByID(customerId);
        List <DataSim> filter = new ArrayList<>();

        if (customer.size() > 0) {
            for (Customer user : customer) {
                List<GasMater> gasData = findGasMeter(user.getGasMaterID());
                if (gasData.size() > 0) {
                    for (GasMater gas : gasData) {
                        String plcID = gas.getPlcId();
                        List<Plc> plcData = findPlc(plcID);
                        if (plcData.size() > 0) {
                            for (Plc plc : plcData) {
                                String simId = plc.getSimDataId();
                                List<DataSim> simData = findSim(simId);
                                filter.addAll(simData);
                            }
                        }
                    }
                }
            }
        }
        return filter;
    }

    public List<Worker> findWorkerByID (String id) {
        ArrayList<Worker> filter = new ArrayList<>();
        if (workerData() != null) {
            for (Worker employee : workerData()) {
                if (employee.getIdEmployee().equalsIgnoreCase(id)) {
                    filter.add(employee);
                }
            }
        }
        return filter;
    }

    public List<Worker> findWorkerByUser (String user) {
        ArrayList<Worker> filter = new ArrayList<>();
        if (workerData() != null) {
            for (Worker employee : workerData()) {
                if (employee.getName().equalsIgnoreCase(user)) {
                    filter.add(employee);
                }
            }
        }
        return filter;
    }

    public List<Worker> findWorkerByEmail (String email) {
        ArrayList<Worker> filter = new ArrayList<>();
        if (workerData() != null) {
            for (Worker employee : workerData()) {
                if (employee.getEmail().equalsIgnoreCase(email)) {
                    filter.add(employee);
                }
            }
        }
        return filter;
    }

    // #################################### General Data search methods ########################################

    public float findPriceByDate (String period) {

        String date = (monthYear.isValid(period))
                ? period
                : (fullDate.isValid(period))
                ? format.dateFormat(period)[1] + "/" + format.dateFormat(period)[2]
                : null;

        if (date != null) {
            for (Prices p: pricesData()) {
                if (p.getPeriod().contains(date)){
                    return p.getValue();
                }
            }
        } else {
            System.err.println("Format date not valid!");
        }
        return -1;
    }



    // #################################### Customer Data search methods ########################################

    // @@ https://stackoverflow.com/questions/18410035/ways-to-iterate-over-a-list-in-java

    public List<Billing> findBillingByUser (String customerID) {

        ArrayList<Billing> filter = new ArrayList<>();

        if (billingData() != null) {
            for (Billing billding : billingData()) {
                if (billding.getIdCustomer().equalsIgnoreCase(customerID)) {
                    filter.add(billding);
                }
            }
            if (filter.size() == 0) System.err.println("User without associated billing!");
        }

        return filter;
    }

    public List<GasMater> findGasMeter(String gasMeterId) {

        ArrayList<GasMater> filter = new ArrayList<>();

        if (gasMaterData() != null) {
            for (GasMater gas : gasMaterData()) {
                if (gas.getIdGasMater().equalsIgnoreCase(gasMeterId)) {
                    filter.add(gas);
                }
            }
            if (filter.size() == 0) System.err.println("User without associated gas meter!");
        }
        return filter;

    }

    public List<DataSim> findSim(String simId) {

        ArrayList<DataSim> filter = new ArrayList<>();

        if (simData() != null) {
            for (DataSim sim : simData()) {
                if (sim.getIdDataSim().equalsIgnoreCase(simId)) {
                    filter.add(sim);
                }
            }
            if (filter.size() == 0) System.err.println("SIM ID not found!");
        }
        return filter;

    }

    public List<Plc> findPlc(String plcId) {

        ArrayList<Plc> filter = new ArrayList<>();

        if (plcData() != null) {
            for (Plc plc : plcData()) {
                if (plc.getIdPlc().equalsIgnoreCase(plcId)) {
                    filter.add(plc);
                }
            }
            if (filter.size() == 0) System.err.println("PLC ID not found!");
        }
        return filter;
    }

    // ####################################### Customer search methods ###########################################

    /*         #### Find a customer by the name ####
    * @param name - Name of the client set in the client JSON list.
    * @return A list of users matching the entered name.
    */

    public List<Customer> findCustomerByName(String name) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getNameCustomer().toLowerCase().contains(name.toLowerCase())) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("User(s) not found!");
        }

        return filter;
    }

    /*         #### Find a customer by the ID (DNI) ####
     * @param ID - ID of the client set in the client JSON list.
     * @return A list of users matching the entered ID.
     */

    public List<Customer> findCustomerByID(String ID) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getIdCustomer().equalsIgnoreCase(ID)) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("ID not found!");
            if (filter.size() > 1) System.err.println("More than one client associated with the same ID has been found!");
        }



        return filter;
    }

    /*         #### Find a customer by the Number Phone ####
     * @param numberPhone - Number Phone of the client set in the client JSON list.
     * @return A list of users matching the entered Number Phone.
     */

    public List<Customer> findCustomerByNumber(String numberPhone) {

        ArrayList<Customer> filter = new ArrayList<>();

        if (customerData() != null) {
            for (Customer customer : customerData()) {
                if (customer.getNumberPhone().equalsIgnoreCase(numberPhone)) {
                    filter.add(customer);
                }
            }
            if (filter.size() == 0) System.err.println("Customer associated to the entered number not found!");
        }
        return filter;
    }
}