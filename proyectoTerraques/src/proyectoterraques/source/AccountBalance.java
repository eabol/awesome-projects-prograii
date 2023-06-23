package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public interface AccountBalance {


   void deposit(double quantity)throws InvalidCharacterException;
   void withdraw(double quantity)throws InvalidCharacterException;

   public void showAccountData();


}
