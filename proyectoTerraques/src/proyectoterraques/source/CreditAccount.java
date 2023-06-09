package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public class CreditAccount extends Account implements AccountBalance {

    public double interest=20; //Interes del 20%
    public double debt;

    public CreditAccount(String accountNumber, String dni) {
        super(accountNumber,dni);
    }


    public double getDebt() {
        return debt;
    }
    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void showAccountData() {
        System.out.println("Account - "+accountNumber);
        System.out.println("Balance - "+amount+"€");
        System.out.println("Debt - "+debt+"€");
        System.out.println("Interest - "+interest+"%");
        System.out.println("Client DNI - "+dni+"\n");

    }


    @Override
    public void deposit(double quantity) throws InvalidCharacterException{

        if ((amount+quantity)>=0){
            amount = amount+quantity;
            //System.out.println("You have deposited "+quantity+"€, your new balance is "+amount+"€\n");
        } else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }


    }

    @Override
    public void withdraw(double quantity) throws InvalidCharacterException {

        if ((amount-quantity)>=0){
            amount= amount-quantity;
            //System.out.println("You have withdrawn "+quantity+"€, your new balance is "+amount+"€\n");
        }else if ((amount-quantity)<0) {
            amount= amount-quantity;
            debt=amount+Math.abs(amount)*(interest/100);
            //System.out.println("You have withdrawn " + quantity + "€, your new balance is " + amount + "€\n");
            //System.out.println("Your debt is "+debt+"€");

        }else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }
    }
}
