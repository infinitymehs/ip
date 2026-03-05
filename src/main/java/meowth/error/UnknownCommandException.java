package meowth.error;

/**
 * Exception thrown when Parser encounters an unrecognized command word.
 * Occurs when user enters invalid command like "xyz" instead of supported commands.
 */
public class UnknownCommandException extends MeowthException{
    
    /**
     * Constructs an UnknownCommandException with unrecognized command message.
     * Informs user that the entered command word is not supported by Meowth.
     */
    public UnknownCommandException(){
        super("Meowth doesn't understand the command!");
    }
}
