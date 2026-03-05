package meowth.error;

/**
 * Exception thrown when attempting to add tasks to a full task list.
 * Maximum capacity of 100 tasks has been reached.
 */
public class FullTaskListException extends MeowthException {
    
    /**
     * Constructs a FullTaskListException with themed capacity error message.
     * Humorously compares task overload to Team Rocket's busy schedule.
     */
    public FullTaskListException(){
        super("Task list is full! Even Team Rocket isn't as busy :(");
    }
}
