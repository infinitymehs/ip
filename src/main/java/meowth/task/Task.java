package meowth.task;

/**
 * Represents a generic task with name and completion status.
 * Base class for specific task types: ToDo, Deadline, Event.
 * Provides common display formatting with status icon.
 */
public class Task{
    
    /** Description of the task. */
    private String taskName;
    
    /** Completion status of the task. */
    private boolean isDone;

    /**
     * Constructs a Task with the given description.
     * Initializes task as not done (isDone = false).
     * 
     * @param taskName Description of the task
     */
    public Task(String taskName){
        this.taskName = taskName;
        isDone = false;
    }

    /**
     * Returns the task description.
     * 
     * @return Task name/description string
     */
    public String getTaskName(){
        return taskName;
    }

    /**
     * Returns the completion status of the task.
     * 
     * @return true if task is marked done, false otherwise
     */
    public boolean getDone(){
        return isDone;
    }

    /**
     * Sets the completion status of the task.
     * 
     * @param toSet true to mark done, false to mark undone
     */
    public void setDone(boolean toSet){
        isDone = toSet;
    }

    /**
     * Prints the task in standard format to console.
     * Shows status icon (" " or "X") followed by task description.
     * Format: "[ ] Task description" or "[X] Task description"
     */
    public void printTask(){
        String done = " ";
        if (isDone){
            done = "X";
        }
        String listLine = "[%s] %s";
        System.out.print(String.format(listLine, done, taskName));
    }
}
