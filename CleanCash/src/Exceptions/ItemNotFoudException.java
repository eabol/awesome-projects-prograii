package Exceptions;

public class ItemNotFoudException extends Exception implements NotFoundException{
    public static String MESSAGE = "ERROR: Item not found";
    public ItemNotFoudException(){
    }
    @Override
    public void logException(){
        System.err.println(MESSAGE);
    }
}
