package proyectoterraques.gui;

import proyectoterraques.exceptions.InvalidCharacterException;
import proyectoterraques.source.Bank;

public class Main2 {
    public static void main(String[] args) throws InvalidCharacterException {

        Bank bank = new Bank("1357","ES");


        /*
        bank.newAccount();
        bank.newAccount();
        bank.getAccounts();
        bank.depositMoney();
        bank.getAccounts();
        bank.withDrawMoney();
        bank.getAccounts();
        bank.showAccount();
         */

        bank.newClient();

        bank.getClients();
        //bank.showClient();
        bank.getAccounts();
        bank.depositMoney();
        bank.removeAccount();
        bank.getClients();
        bank.getAccounts();
        bank.showClient();
    }
}
