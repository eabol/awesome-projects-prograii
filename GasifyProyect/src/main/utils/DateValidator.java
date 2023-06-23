package main.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator {

    private String dateFormat;

    //@@ https://www.baeldung.com/java-string-valid-date

    public DateValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }
    public boolean isValid(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public String[] dateFormat(String date) {
        return date.split("/");
    }

}
