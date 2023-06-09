package Basis;

import java.time.LocalDate;

public class FailuireException extends Exception implements Incidence {
    private int idMachine;
    private LocalDate date;

    public FailuireException(int idMachine) {
        super("Se ha producido una Averia en la máquina "+ idMachine +"");
        this.idMachine = idMachine;
        setDate();
    }


    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }
}
