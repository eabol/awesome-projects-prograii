/*

import main.core.data.Billing;
import main.core.Customer;

import main.core.equipment.DataSim;
import main.utils.*;


import java.util.ArrayList;
import java.util.List;

 */


import main.core.data.Data;
import main.core.menu.MenuOptions;

import java.io.IOException;

public class Main { //50394857E

    public static void main(String[] args) throws IOException {

        //ParseData data = new ParseData();
        //data.usage("72171365X", "01/01/2023", "31/05/2023");


        //ParseData data = new ParseData();
        //data.billingHandler("72171365X", "01/06/2023");
        //InvoiceGeneratorHTTP prueba = new InvoiceGeneratorHTTP();

        //System.out.println(prueba.generateInvoice("customerName",data.customerData().get(0).getNameCustomer(),"desc","Mensaje de prueba", "customerAddress", data.customerData().get(0).getAddress()));

        MenuOptions menu = new MenuOptions();
        menu.principalMenu();

        //Data prueba = new Data();

        //System.out.println(prueba.workerData().get(0).getPassword());
/*
        ParseData data = new ParseData();

        System.out.println(data.workerData().size());
        Worker employ = new Worker();

        employ = new Worker("EMP-999999","Alberto","tecnico2@gmail.com","999","Naturgy","IT");

        FileWriter write = new FileWriter();
        write.writeWorkersData(employ);

        System.out.println(data.workerData().size());

 */

        //data.findBillingByUser("72171365X").get(0).getAddress();ç

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

        //Data data = new Data();
        //System.out.println(data.getMonthDifference("01/01/2023","14/03/2023"));
       // System.out.println(data.usage("72171365X", "01/02/2023", "31/03/2023"));
/*
        Data data = new Data();

        List<Billing> users = data.monthlyBill("72171365X", "01/01/2023", "31/12/2023");

        for (Billing user : users) {
            System.out.println(user.getFirstDate());
            System.out.println(user.getFirstValue());
            System.out.println(user.getSecondDate());
            System.out.println(user.getSecondValue());
            System.out.println("");
        }

 */

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
