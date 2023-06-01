package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public class DebitAccount extends Account implements AccountMethods{

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
        System.out.println("Amount - "+amount+"€\n");

    }

    @Override
    public void deposit(double quantity) throws InvalidCharacterException{

        if ((amount+quantity)>=0){
            amount = amount+quantity;
            System.out.println("You have deposited "+quantity+"€, your new balance is "+amount+"€");
        } else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }


    }

    @Override
    public void withdraw(double quantity) throws InvalidCharacterException {

        if ((amount-quantity)<0){
            System.out.println("You don't have enough money to do this operation, your balance is "+amount+"€");
        } else if ((amount-quantity)>=0){
            amount= amount-quantity;
            System.out.println("You have withdrawn "+quantity+"€, your new balance is "+amount+"€");
        } else {
            throw new InvalidCharacterException("Invalid option, only numeric characters allowed");
        }
    }
}
