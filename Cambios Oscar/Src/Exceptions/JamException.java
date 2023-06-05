package Exceptions;

import Interface.Incidence;

import java.time.LocalDate;

public class JamException extends Exception implements Incidence {

    private int idMachine;
    private LocalDate date;
    private int idJam;

    public JamException(int idMachine, int idJam) {
        super("Se ha producido un atasco en la máquina " + idMachine + " en la fecha " + LocalDate.now() + " en el producto " + idJam + "");
        this.idMachine = idMachine;
        this.idJam = idJam;
        setDate();

    }

    @Override
    public void setDate() {
        this.date = LocalDate.now();
    }
}
