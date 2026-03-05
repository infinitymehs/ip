package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

/**
 * Represents a command to delete a task from the task list.
 * Removes task at the specified 0-based index.
 */
public class DeleteCommand extends Command {
    
    /** The 0-based index of the task to delete. */
    private int idx;

    /**
     * Constructs a DeleteCommand with the specified task index.
     * 
     * @param idx The 0-based index of the task to delete from taskList.
     */
    public DeleteCommand(int idx){
        this.idx = idx;
    }

    /**
     * Deletes the task at the specified index from the task list.
     * Shows error message via UI if index is invalid or deletion fails.
     *
     * @param taskList The task list containing the task to delete.
     * @param ui The user interface for displaying errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.delete(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
