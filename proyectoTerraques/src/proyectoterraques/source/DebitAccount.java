package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public class DebitAccount extends Account implements AccountBalance {

    public DebitAccount(String accountNumber) {
        super(accountNumber);
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
        System.out.println("Balance - "+amount+"€\n");

    }

    @Override
    public void deposit(double quantity) throws InvalidCharacterException{

        if ((amount+quantity)>=0){
            amount = amount+quantity;
            System.out.println("You have deposited "+quantity+"€, your new balance is "+amount+"€\n");
        } else if ((amount+quantity)<=0){
            throw new InvalidCharacterException("Invalid option, only positive amounts");
        }


    }

    @Override
    public void withdraw(double quantity) throws InvalidCharacterException {

        if ((amount-quantity)<0){
            System.err.println("You don't have enough money to do this operation, your balance is "+amount+"€\n");
        } else if ((amount-quantity)>=0){
            amount= amount-quantity;
            System.out.println("You have withdrawn "+quantity+"€, your new balance is "+amount+"€\n");
        } else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }
    }
}
