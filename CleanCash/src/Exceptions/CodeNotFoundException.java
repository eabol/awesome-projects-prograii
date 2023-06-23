package Exceptions;

public class CodeNotFoundException extends Exception implements NotFoundException{
    public static String MESSAGE = "ERROR: Code not found";
    public CodeNotFoundException(){
    }

    @Override
    public void logException(){
        System.err.println(MESSAGE);
    }
}