package Exceptions;

public class CodeNotFoundException extends Exception{
    public static String MESSAGE = "ERROR: Code not found";
    public CodeNotFoundException(String message){
        super(message);
    }
}