package main.utils;

import main.core.data.Billing;
import main.core.data.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProcessData extends Data {
    DateValidator fullDate;
    DateValidator monthYear;
    DateValidator format;

    public ProcessData() {
        fullDate = new DateValidator("dd/MM/yyyy");
        monthYear = new DateValidator("MM/yyyy");
    }

    // @@ https://stackoverflow.com/questions/26075490/filter-an-arraylist-with-dates-by-start-and-end-time
    // @@ https://stackoverflow.com/questions/13037654/subtract-two-dates-in-java

    public List<String> allUsage(String customerID, String firstDate, String secondDate) {
        if (fullDate.isValid(firstDate) && fullDate.isValid(secondDate)) {
            List<Billing> filter = monthlyBill(customerID, firstDate, secondDate);
            if (filter != null) {
                ArrayList<String> usage = new ArrayList<>();
                for (Billing b : filter) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(b.getFirstDate(), formatter);
                    String data = date.getMonth() + "/" + b.getIdCustomer() + "/" + b.getIdGasMeter() + "/" + priceCalc(customerID, b.getFirstDate()) + "/" + date.getMonthValue();
                    usage.add(data);
                }
            }
        } else {
            System.err.println("Format date not valid!");
        }
        return null;
    }

    /*         #### Find a specific Month Bill ####
     * @param customerId - ID of the client set in the client JSON list.
     * @param date - Date in MM/YYYY format.
     * @return A list of billing matching the entered customerId and the entered date.
     */

    public List<Billing> findSpecificMonthBill (String customerId, String date) {

        date = (monthYear.isValid(date))
                ? date
                : (fullDate.isValid(date))
                ? format.dateFormat(date)[1] + "/" + format.dateFormat(date)[2]
                : null;

        if (date != null) {

            List<Billing> filter = new ArrayList<>();
            List<Billing> getUser = findBillingByUser(customerId);
            if (getUser.size() > 0) {
                for (Billing user : getUser) {

                    if (user.getFirstDate().contains(date) && user.getIdCustomer().equalsIgnoreCase(customerId)) {
                        filter.add(user);
                    }
                }
                if (filter.size() == 0) System.err.println("No billing available for the date entered!");
            }
            return filter;

        } else {
            System.err.println("Format date not valid!");
        }
        return null;
    }

    public List<Billing> monthlyBill (String customerId, String firstDate, String secondDate) {
        if (fullDate.isValid(firstDate) && fullDate.isValid(secondDate)) {
            List<Billing> filtro = new ArrayList<>();
            List<Billing> getUser = findBillingByUser(customerId);
            if (getUser.size() > 0) {
                for (Billing user : getUser) {
                    LocalDate enteredFirstDate = LocalDate.parse(firstDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate userFirstDate = LocalDate.parse(user.getFirstDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate enteredSecondDate = LocalDate.parse(secondDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate userSecondDate = LocalDate.parse(user.getSecondDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    if ((userFirstDate.isEqual(enteredFirstDate) || userFirstDate.isAfter(enteredFirstDate)) && (userSecondDate.isEqual(enteredSecondDate) || userSecondDate.isBefore(enteredSecondDate))) {
                        filtro.add(user);
                    }
                }
                if (filtro.size() == 0) System.err.println("No invoices available in the selected date range!");
            }
            return filtro;

        } else {
            System.err.println("Format date not valid!");
        }
        return null;
    }

    public float priceCalc(String customerId, String period) {

        List <Billing> filter = findSpecificMonthBill(customerId, period);

        if (filter != null) {
            for (Billing b : filter) {
                float price = findPriceByDate(period);
                if (price != -1) {
                    return (float) ((diffValues(customerId, period) * 11.7) * price) + 12;
                }
            }
        }
        return -1;
    }

    public float diffValues (String customerID, String date) {
        if (monthYear.isValid(date)) {
            List<Billing> filter = findBillingByUser(customerID);
            if (filter.size() > 0) {
                for (Billing b : filter) {
                    if (b.getIdCustomer().equalsIgnoreCase(customerID) && b.getFirstDate().contains(date)) {
                        return b.getSecondValue() - b.getFirstValue();
                    }
                }
            }
        } else {
            System.err.println("Format date not valid!");
        }
        return -1;
    }

}
