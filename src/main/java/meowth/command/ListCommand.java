package meowth.command;
import meowth.task.*;
import meowth.ui.Meowth;

public class ListCommand extends Command {

    public ListCommand(){
    }

    public void execute(TaskList taskList, Meowth ui){
        taskList.displayList();
    }
}
