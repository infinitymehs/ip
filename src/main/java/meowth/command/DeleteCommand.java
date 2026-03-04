package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

public class DeleteCommand extends Command {
    private int idx;

    public DeleteCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.delete(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
        
    }
}
