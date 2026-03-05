package meowth.error;

/**
 * Exception thrown when attempting to access a task using an invalid index.
 * Occurs during mark, unmark, or delete operations with out-of-bounds indices.
 */
public class InvalidIndexException extends MeowthException{
    
    /**
     * Constructs an InvalidIndexException with themed index error message.
     * Informs user that the specified task index is unreachable.
     */
    public InvalidIndexException(){
        super("Meowth can't reach that task, index is incorrect!");
    }
}
