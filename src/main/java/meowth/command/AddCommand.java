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
        taskList.addTask(newTask);
    }
}
