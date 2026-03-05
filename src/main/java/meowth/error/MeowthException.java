package meowth.error;

/**
 * Base exception class for all Meowth application errors.
 * All specific exceptions (InvalidInputException, InvalidIndexException, etc.) extend this class.
 */
public class MeowthException extends Exception{
    
    /**
     * Constructs a MeowthException with the specified error message.
     * Passes the message to the parent Exception class for standard handling.
     * 
     * @param message Descriptive error message for the user
     */
    public MeowthException(String message) {
        super(message);
    }
}
