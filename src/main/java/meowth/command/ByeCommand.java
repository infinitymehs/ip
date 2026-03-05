package meowth.command;
import meowth.task.TaskList;
import meowth.ui.Meowth;

/**
 * Represents a command to exit the application.
 * Prints farewell message, saves tasks, and stops the application loop.
 */
public class ByeCommand extends Command{
    
    /**
     * Constructs a ByeCommand with no parameters.
     */
    public ByeCommand(){
    }

    /**
     * Executes the exit sequence.
     * Displays goodbye message, saves current task list, and sets running flag to false.
     *
     * @param taskList The current task list.
     * @param ui The user interface for displaying messages and controlling app state.
     */
    public void execute(TaskList taskList, Meowth ui){
        Meowth.printEnd();
        Command saveCommand = new SaveCommand();
        saveCommand.execute(taskList, ui);
        ui.setRunning(false);
    }
}
