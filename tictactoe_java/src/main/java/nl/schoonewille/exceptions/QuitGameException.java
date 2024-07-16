package nl.schoonewille.exceptions;

public class QuitGameException extends RuntimeException{
    public QuitGameException(String errorMessage) {
        super(errorMessage);
    }
}
