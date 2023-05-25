package proyectoterraques.source;

import java.util.ArrayList;
import java.util.List;

public class ShareholderClient extends Client implements ClientMethods{

    List<DebitAccount> debitAccounts;
    CreditAccount credit_Account;

    public ShareholderClient(String dni, String name, String surname, String address, String phoneNumber) {
        super(dni, name, surname, address, phoneNumber);
        debitAccounts= new ArrayList<>();
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

        for (int i=0;i<debitAccounts.size();i++){
            System.out.println((i+1)+" - "+debitAccounts.get(i).getAccountNumber());
        }

    }
}
