package meowth.command;
import meowth.task.*;
import meowth.error.*;
import meowth.ui.*;

public class AddCommand extends Command { 
    private Task newTask;

    public AddCommand(Task newTask){
        this.newTask = newTask;
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.addTask(newTask);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
