package meowth.command;
import meowth.ui.*;
import meowth.task.*;

/**
 * Abstract base class for all command implementations.
 * Defines the common execute() method signature used by polymorphism.
 * Concrete subclasses override execute() for specific behaviors.
 */
public class Command {

    /**
     * Executes the command on the given task list and user interface.
     * Concrete subclasses provide specific implementation.
     *
     * @param taskList The task list to operate on.
     * @param ui The user interface for output and state management.
     */
    public void execute(TaskList taskList, Meowth ui){
    }
}
