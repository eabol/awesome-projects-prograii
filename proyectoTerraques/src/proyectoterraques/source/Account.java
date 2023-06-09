package proyectoterraques.source;

public abstract class Account {

    String accountNumber;
    double amount;
    String dni;

    public Account(String accountNumber,String dni) {
        this.accountNumber=accountNumber;
        amount = 0;
        this.dni=dni;
    }

    public String getDni() {
        return dni;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

}
