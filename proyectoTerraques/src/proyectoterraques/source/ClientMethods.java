package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public interface ClientMethods {

    void addAccount(Account account);
    void removeAccount(String accountNumber) ;
    void listAccounts();

}
