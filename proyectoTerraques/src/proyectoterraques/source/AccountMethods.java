package proyectoterraques.source;

import proyectoterraques.exceptions.InvalidCharacterException;

public interface AccountMethods {


   void deposit(double quantity)throws InvalidCharacterException;
   void withdraw(double quantity)throws InvalidCharacterException;

}
