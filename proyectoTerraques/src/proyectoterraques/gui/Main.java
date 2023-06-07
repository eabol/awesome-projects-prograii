package proyectoterraques.gui;

import proyectoterraques.source.*;

public class Main {
    public static void main(String[] args) {

        DebitAccount debito0 = new DebitAccount("000000");
        CreditAccount credito0 = new CreditAccount("0000");
        DebitAccount debito1 = new DebitAccount("0000001");
        DebitAccount debito2 = new DebitAccount("0000002");
        CreditAccount credito1 = new CreditAccount("0001");

        debito0.showAccountData();
        credito0.showAccountData();

        ShareholderClient shareholderClient = new ShareholderClient("7220987K","Juan","Lopez","San fernando","678009834");
        StandardClient standardClient = new StandardClient("78953409J","Mario","Garcia","Ayuntamiento","654780923");

        System.out.println(shareholderClient.getFullData());
        System.out.println(standardClient.getFullData());

        shareholderClient.addAccount(debito0);
        shareholderClient.addAccount(credito0);
        shareholderClient.addAccount(debito1);
        shareholderClient.addAccount(credito1);

        //standardClient.addAccount(debito0);
        //standardClient.addAccount(debito1);
        //standardClient.addAccount(credito0);
        //standardClient.addAccount(credito1);


        shareholderClient.listAccounts();

        shareholderClient.removeAccount("000000");
        //shareholderClient.addAccount(debito1);
        shareholderClient.listAccounts();
    }
}
