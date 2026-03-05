package meowth.error;

/**
 * Exception thrown when user attempts to list or find tasks in an empty task list.
 * Provides user-friendly message suggesting they add tasks first.
 */
public class EmptyTaskListException extends MeowthException {
    
    /**
     * Constructs an EmptyTaskListException with themed error message.
     * Message humorously prompts user to add tasks before listing.
     */
    public EmptyTaskListException(){
        super("List is empty, have you taken over the world?");
    }
}
