package exceptions;

import main.Alert;
import interfaces.Incidence;

import java.time.LocalDate;

public class FailureException extends Alert implements Incidence {
    private int idMachine;
    private LocalDate date;
    public FailureException(int idMachine) {
        super("A failure has occurred in machine number" + idMachine + "at" + LocalDate.now() + ". Get in touch with the manager.");
        this.idMachine = idMachine;
        setDate();
    }

    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public void alertException() {
        System.out.println("Failure exception detected");
    }
}
