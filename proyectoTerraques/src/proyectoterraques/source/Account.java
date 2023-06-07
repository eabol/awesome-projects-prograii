package proyectoterraques.source;

public abstract class Account {

    String accountNumber;
    double amount;

    public Account(String accountNumber) {
        this.accountNumber=accountNumber;
        amount = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

}
