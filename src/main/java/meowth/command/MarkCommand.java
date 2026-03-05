package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

/**
 * Represents a command to mark a task as done/completed.
 * Updates the status of the task at the specified index.
 */
public class MarkCommand extends Command {
    
    /** The 0-based index of the task to mark as done. */
    private int idx; 

    /**
     * Constructs a MarkCommand with the specified task index.
     * 
     * @param idx The 0-based index of the task to mark as done.
     */
    public MarkCommand(int idx){
        this.idx = idx;
    }

    /**
     * Marks the task at the specified index as done.
     * Shows error message via UI if index is invalid or marking fails.
     *
     * @param taskList The task list containing the task to mark.
     * @param ui The user interface for displaying errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.markDone(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
