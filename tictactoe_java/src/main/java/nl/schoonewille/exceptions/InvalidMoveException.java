package nl.schoonewille.exceptions;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(String errormessage) {
        super(errormessage);
    }

}
