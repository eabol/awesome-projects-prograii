import java.time.LocalDate;

public class FailureException extends Exception implements Incidence{
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
}
