package proyectoterraques.source;

public interface ClientManagement {

    boolean addAccount(Account account);
    void removeAccount(String accountNumber) ;
    void listAccounts();

}
