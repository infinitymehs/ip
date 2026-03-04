package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

public class ListCommand extends Command {

    public ListCommand(){
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.displayList();
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
