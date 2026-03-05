package meowth.task;

/**
 * Represents a deadline task with a specific due date.
 * Extends Task to include deadline information in display format.
 */
public class Deadline extends Task{
    
    /** Static field storing the deadline date for this task instance. */
    private static String deadline;

    /**
     * Constructs a Deadline task with the given name and due date.
     * Calls superclass constructor and sets the static deadline field.
     * 
     * @param taskName Description of the deadline task
     * @param deadlineDate The due date for this task
     */
    public Deadline(String taskName, String deadlineDate){
        super(taskName);
        deadline = deadlineDate;
    }

    /**
     * Returns the deadline date for this task.
     * Provides access to the static deadline field.
     * 
     * @return The deadline date string
     */
    public static String getDeadline(){
        return deadline;
    }

    /**
     * Prints the deadline task in standard format.
     * Shows [D] prefix, task status, description, and "(by: date)" suffix.
     */
    public void printTask(){
        System.out.print("[D]");
        super.printTask();
        System.out.print(String.format(" (by: %s)", deadline));
    }
}
