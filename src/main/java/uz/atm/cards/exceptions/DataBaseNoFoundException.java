package uz.atm.cards.exceptions;

public class DataBaseNoFoundException extends RuntimeException{
    //
    private Long exceptionMessage = 1L;
    private final String message;

    public DataBaseNoFoundException(Long exceptionMessage, String message) {
        this.exceptionMessage = exceptionMessage;
        this.message = message;
    }

}
