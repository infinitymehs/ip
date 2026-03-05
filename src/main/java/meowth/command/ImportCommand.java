package meowth.command;
import meowth.task.TaskList;
import meowth.error.*;
import meowth.save.*;
import meowth.ui.*;

/**
 * Represents a command to import tasks from external storage into the current task list.
 * Loads tasks from saved file into memory.
 */
public class ImportCommand extends Command{
    
    /**
     * Constructs an ImportCommand with no parameters.
     */
    public ImportCommand(){
    }

    /**
     * Imports tasks from external storage into the task list.
     * Shows error message via UI if import operation fails.
     *
     * @param taskList The task list to populate with imported tasks.
     * @param ui The user interface for displaying errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            FileSaver.importTaskList(taskList);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
