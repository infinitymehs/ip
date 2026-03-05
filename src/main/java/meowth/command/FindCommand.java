package meowth.command;
import meowth.task.TaskList;
import meowth.ui.Meowth;
import meowth.error.MeowthException;

/**
 * Represents a command to search for tasks matching a keyword.
 * Finds and displays tasks containing the specified search string.
 */
public class FindCommand extends Command{
    
    /** The keyword to search for in task names. */
    private String stringToFind;

    /**
     * Constructs a FindCommand with the specified search keyword.
     * 
     * @param stringToFind The keyword to search for in task descriptions.
     */
    public FindCommand(String stringToFind){
        this.stringToFind = stringToFind;
    }

    /**
     * Searches the task list for tasks matching the keyword.
     * Displays matching tasks or shows error if search fails.
     *
     * @param taskList The task list to search through.
     * @param ui The user interface for displaying results or errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
           taskList.find(stringToFind); 
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
