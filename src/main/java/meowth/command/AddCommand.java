package meowth.command;
import meowth.task.*;
import meowth.error.*;
import meowth.ui.*;

/**
 * Represents a command to add a new task to the task list.
 * Creates and adds Todo, Deadline, or Event tasks based on parsed input.
 */
public class AddCommand extends Command { 
    
    /** The task to be added to the task list. */
    private Task newTask;

    /**
     * Constructs an AddCommand with the specified task.
     * 
     * @param newTask The task to add (Todo, Deadline, or Event).
     */
    public AddCommand(Task newTask){
        this.newTask = newTask;
    }

    /**
     * Adds the task to the task list.
     * Shows error message via UI if task list capacity exceeded.
     *
     * @param taskList The task list to modify.
     * @param ui The user interface to display errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.addTask(newTask);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
