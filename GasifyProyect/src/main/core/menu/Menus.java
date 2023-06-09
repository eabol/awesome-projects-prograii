package main.core.menu;

import main.core.data.Billing;
import main.core.Customer;
import main.utils.ProcessData;
import main.utils.TableList;

import java.math.BigDecimal;
import java.util.List;

public abstract class Menus {

    private TableList table;
    private ProcessData find;
    private BigDecimal decimalFix;

    public Menus() {
        find = new ProcessData();
    }

    private BigDecimal prettyDecimal (float number) {
        decimalFix = new BigDecimal(number);
        return decimalFix.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    protected void principal() {
        table = new TableList(2, "Number", "Option Name").sortBy(0).withUnicode(true);
        table.addRow("1.", "Login");
        table.addRow("2.", "Register");
        table.addRow("3.", "Exit");
        table.print();
    }

    protected void registerCheck(String user, String email, String dep) {
        table = new TableList(2, "Type", "Input");
        table.addRow("Username", user);
        table.addRow("Email", email);
        table.addRow("Department", dep);
        table.print();
    }

    protected void logged() {
        table = new TableList(2, "Number", "Option Name").sortBy(0).withUnicode(true);
        table.addRow("1.", "Find Costumer by Name");
        table.addRow("2.", "Find Costumer by ID");
        table.addRow("3.", "Work with a Costumer");
        table.addRow("4.", "Exit");
        table.print();
    }

    protected void actionsCustomer() {
        table = new TableList(2, "Number", "Option Name").sortBy(0).withUnicode(true);
        table.addRow("1.", "Find billing by Date");
        table.addRow("2.", "Find billing by range date");
        table.addRow("3.", "Generate invoice");
        table.addRow("4.", "Exit");
        table.print();
    }

    protected void customerList(List<Customer> customers) {
        table = new TableList(2, "ID", "Name").sortBy(0).withUnicode(true);
        for (Customer user : customers) {
            table.addRow(user.getIdCustomer(), user.getNameCustomer());
        }
        table.print();
    }

    protected void billSpecificMonth(List<Billing> data, String customerId, String date) {
        table = new TableList(4, "CustomerID", "GasMeterID","Consumo en m3" ,"Consumo €").withUnicode(true);
        for (Billing u : data) {
            table.addRow(u.getIdCustomer(), u.getIdGasMeter(), String.valueOf(find.diffValues(customerId, date)), String.valueOf(prettyDecimal(find.priceCalc(customerId, date))) + " €");
        }
        table.print();
    }

    protected void billRangeMonth(List<String> info) {
        table = new TableList(6,"Nº Mes","Mes" ,"CustomerID", "GasMeterID","Consumo en m3" ,"Consumo €").sortBy(0).withUnicode(true);
        float allUsageM2 = 0;
        float allMoney = 0;

        for (String d : info) {
            String[] parts = d.split("/");
            table.addRow(parts[5], parts[0], parts[1], parts[2], parts[4], String.valueOf(prettyDecimal(Float.parseFloat(parts[3]))));
            allUsageM2 += Float.parseFloat(parts[4]);
            allMoney += Float.parseFloat(parts[3]);
        }

        table.print();
        table = new TableList(2, "Total m3 / Range", "Total € / Range");
        table.addRow(String.valueOf(allUsageM2), String.valueOf(prettyDecimal(allMoney)));
        table.print();
    }

}
