package meowth.command;
import meowth.task.TaskList;
import meowth.save.*;
import meowth.ui.*;

/**
 * Represents a command to save the current task list to a text file.
 * Writes tasks to file to save task list when application restarts.
 */
public class SaveCommand extends Command{
    
    /**
     * Constructs a SaveCommand with no parameters.
     */
    public SaveCommand(){
    }

    /**
     * Saves the task list to external storage.
     * Shows error message via UI if save operation fails.
     *
     * @param taskList The task list to save to file.
     * @param ui The user interface for displaying errors.
     */
    public void execute(TaskList taskList, Meowth ui){
        try{
            FileSaver.saveTaskList(taskList);
        } catch (Exception e){
            ui.getError(e);
        }
    }   
}
