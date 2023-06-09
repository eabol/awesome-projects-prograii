package Exceptions;

public class ItemNotFoudException extends Exception{
    public static String MESSAGE = "ERROR: Item not found";
    public ItemNotFoudException(String message){
        super(message);
    }
}
