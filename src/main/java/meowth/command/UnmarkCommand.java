package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

/**
 * Represents a command to mark a task as not done/undone.
 * Updates the status of the task at the specified index back to incomplete.
 */
public class UnmarkCommand extends Command {
    
    /** The 0-based index of the task to mark as undone. */
    private int idx; 

    /**
     * Constructs an UnmarkCommand with the specified task index.
     * 
     * @param idx The 0-based index of the task to mark as undone.
     */
    public UnmarkCommand(int idx){
        this.idx = idx;
    }

    /**
     * Marks the task at the specified index as undone.
     * Shows error message via UI if index is invalid or unmarking fails.
     *
     * @param taskList The task list containing the task to unmark.
     * @param ui The user interface for displaying errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.markUndone(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
