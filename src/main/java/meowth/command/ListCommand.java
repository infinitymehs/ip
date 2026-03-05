package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

/**
 * Represents a command to display all tasks in the task list.
 * Shows the complete list of current tasks with their status.
 */
public class ListCommand extends Command {

    /**
     * Constructs a ListCommand with no parameters.
     */
    public ListCommand(){
    }

    /**
     * Displays all tasks in the task list.
     * Shows error message via UI if display operation fails.
     *
     * @param taskList The task list to display.
     * @param ui The user interface for displaying the task list or errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.displayList();
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
