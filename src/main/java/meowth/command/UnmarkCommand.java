package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

public class UnmarkCommand extends Command {
    private int idx; 

    public UnmarkCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.markUndone(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
        
    }
}
