package meowth.error;

/**
 * Exception thrown when user provides invalid command input format.
 * Occurs during parsing of todo, deadline, event, or other malformed commands.
 */
public class InvalidInputException extends MeowthException {
    
    /**
     * Constructs an InvalidInputException with parsing error message.
     * Informs user that the input format was not recognized by parser.
     */
    public InvalidInputException(){
        super("Meowth does not understand your inputs!");
    }
}
