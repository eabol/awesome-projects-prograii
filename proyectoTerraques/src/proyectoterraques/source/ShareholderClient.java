package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShareholderClient extends Client implements ClientManagement{

    Scanner scNumber = new Scanner(System.in);
    Scanner scText = new Scanner(System.in);


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
    public boolean addAccount(Account account)  {

            if (account instanceof DebitAccount) {
                debitAccounts.add((DebitAccount) account);
                //System.out.println("\nDebit account succesfully created and vinculated");
                return false;
            }
            else if (account instanceof CreditAccount) {
                if (credit_Account==null){
                    credit_Account = (CreditAccount) account;
                    //System.out.println("\nCredit account succesfully created and vinculated");
                    return false;
                }else {
                    System.out.println("\nYou can't vinculate another credit account to the client");
                    return true;
                }

            }
        return false;
    }

    @Override
    public void removeAccount(String accountNumber) {

        int found=0;

     if (credit_Account.accountNumber.equalsIgnoreCase(accountNumber)){
         credit_Account=null;
         found=1;
     }
     for (int i=0; i <debitAccounts.size();i++){
         if (debitAccounts.get(i).getAccountNumber().equalsIgnoreCase(accountNumber)) {
             debitAccounts.remove(i);
             found=2;
         }
     }

     if (found==1){
         System.out.println("Credit Account successfully removed\n");
     }else if(found==2){
         System.out.println("Debit Account successfully removed\n");

     }else {
         System.out.println("Account not found to remove\n");
     }

    }

    @Override
    public void listAccounts() {

        System.out.println(getFullName()+" Debit Accounts: ");

        if (debitAccounts.size()>0){
            for (int i=0;i<debitAccounts.size();i++){
                debitAccounts.get(i).showAccountData();
            }
        }else{
            System.out.println("None\n");

        }

        System.out.println(getFullName()+" Credit Account: ");
        if (credit_Account!=null){
            credit_Account.showAccountData();
        } else {
            System.out.println("None\n");
        }

    }
}
