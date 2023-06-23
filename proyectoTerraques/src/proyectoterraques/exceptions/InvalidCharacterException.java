package proyectoterraques.exceptions;

public class InvalidCharacterException extends Exception{

    public InvalidCharacterException(String message) {
        super(message);
    }

    //TODO no sabia como declararla
    /*
    public class InvalidCharacterException extends Exception {
        public InvalidCharacterException() {
            super("Carácter inválido, solo se aceptan números");
        }
    }*/


}
