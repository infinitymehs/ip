package meowth.error;

/**
 * Exception thrown when no tasks match the search keyword in find operation.
 * Occurs when user searches for tasks but none contain the specified string.
 */
public class NoRelevantTaskException extends MeowthException{
    
    /**
     * Constructs a NoRelevantTaskException with search failure message.
     * Informs user that no matching tasks were found in the task list.
     */
    public NoRelevantTaskException(){
        super("Meowth could not find any relevant tasks!");
    }
}
