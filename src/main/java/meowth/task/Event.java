package meowth.task;

/**
 * Represents an event task with start and end times.
 * Extends Task to include time range information in display format.
 */
public class Event extends Task {
    
    /** Static field storing the start time for this event instance. */
    private static String from;
    
    /** Static field storing the end time for this event instance. */
    private static String to; 

    /**
     * Constructs an Event task with the given name and time range.
     * Calls superclass constructor and sets the static time fields.
     * 
     * @param taskName Description of the event task
     * @param from Start time of the event
     * @param to End time of the event
     */
    public Event(String taskName, String from, String to){
        super(taskName);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start time of this event.
     * Provides access to the static from field.
     * 
     * @return The start time string
     */
    public static String getFrom(){
        return from;
    }

    /**
     * Returns the end time of this event.
     * Provides access to the static to field.
     * 
     * @return The end time string
     */
    public static String getTo(){
        return to;
    }

    /**
     * Prints the event task in standard format.
     * Shows [E] prefix, task status, description, and "(from: time to: time)" suffix.
     */
    public void printTask(){
        System.out.print("[E]");
        super.printTask();
        System.out.print(String.format(" (from: %s to: %s)",from, to));
    }
}
