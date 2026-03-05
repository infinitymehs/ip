package meowth.command;
import meowth.task.*;
import meowth.ui.*;

/**
 * Represents a command to handle and display generic error messages.
 * Provides fallback behavior when parsing or execution fails.
 */
public class ErrorCommand extends Command{
    
    /**
     * Constructs an ErrorCommand with no parameters.
     */
    public ErrorCommand(){

    }

    /**
     * Displays a generic error message to the user.
     * Instructs user to try their command again.
     *
     * @param taskList The current task list (unused by this command).
     * @param ui The user interface for output (also unused as this uses direct print).
     */
    public void execute(TaskList taskList, Meowth ui){
        System.out.println("Something went wrong, please try again");
    }
}
