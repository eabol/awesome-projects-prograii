package proyectoterraques.source;

public class StandardClient extends Client implements ClientMethods{

    DebitAccount debit_Account;

    public StandardClient(String dni, String name, String surname, String address, String phoneNumber) {
        super(dni, name, surname, address, phoneNumber);
    }

    @Override
    public String getDni() {
        return super.getDni();
    }

    @Override
    public String getFullName() {
        return super.getFullName();
    }

    @Override
    public String getFullData() {
        return super.getFullData();
    }

    @Override
    public void addAccount(Account cuenta) {
        //Todo

    }

    @Override
    public void removeAccount(Account cuenta) {
        //Todo

    }

    @Override
    public void listAccounts() {

        //Todo

    }
}

