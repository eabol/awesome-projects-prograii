import main.core.Billing;
import main.core.Customer;
import main.core.Data;
import main.core.DataSim;
import main.utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        //FileReaderV2 br = new FileReaderV2();
        //ArrayList<String> prueba = br.fileReading("./src/main/data/txt/customers.json");

        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate date = LocalDate.parse("05/06/2023", formatter);
        //System.out.println(date);


/*
        ParseData data = new ParseData();

        for (Customer allCustomers : data.customerData()) {
            System.out.println(allCustomers.getNameCustomer());

        }

 */

        Data data = new Data();

        List<Billing> users = data.monthlyBill("72171365X", "01/01/2023", "31/12/2023");

        for (Billing user : users) {
            System.out.println(user.getFirstDate());
            System.out.println(user.getFirstValue());
            System.out.println(user.getSecondDate());
            System.out.println(user.getSecondValue());
            System.out.println("");
        }

        //System.out.println(users.get(1));

        //System.out.println(data.findSimNumber("72171365X"));

        //String fecha = "02/04/2023";

        //fecha.split("/");

        //System.out.println(data.diffDate());


        //Customer customer1 = data.Testing().get(0);

        //size = data.Testing().size();





        //System.out.println(customer1.getNameCustomer());

        //System.out.println(data.Testing());

        //System.out.println(data);



        //br.fileReading("GasifyProyect/src/main/data/txt/Customers.txt");

        /*ParserData p1 = new ParserData();

        p1.parserCustomer();
        p1.parserDataSim();
        p1.parserGasMater();
        p1.parserPlc();

         */

        //p1.parserWorkers();




    }
}
