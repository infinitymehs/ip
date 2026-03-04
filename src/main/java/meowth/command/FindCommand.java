package meowth.command;
import meowth.task.TaskList;
import meowth.ui.Meowth;
import meowth.error.MeowthException;

public class FindCommand extends Command{
    private String stringToFind;

    public FindCommand(String stringToFind){
        this.stringToFind = stringToFind;
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
           taskList.find(stringToFind); 
        } catch (MeowthException e){
            ui.getError(e);
        }
        
    }
}
