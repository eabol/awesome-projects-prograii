import java.time.LocalDate;

public class JamException extends Exception implements Incidence{
    private int idMachine;
    private LocalDate date;
    private int idProduct;

    public JamException(int idMachine,  int idProduct) {
        super("A failure has occurred in machine number" + idMachine + "at" + LocalDate.now() + "with the product number" + idProduct + ". Get in touch with the manager.");
        this.idMachine= idMachine;
        this.idProduct= idProduct;
        setDate();
    }

    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }
}
