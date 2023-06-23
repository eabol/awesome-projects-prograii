package main;

public abstract class Alert extends Exception {
    public Alert(String message) {
        super(message);
    }
    public void alertException() {

    }
}
