package meowth.command;
import meowth.error.MeowthException;
import meowth.task.*;
import meowth.ui.Meowth;

public class MarkCommand extends Command {
    private int idx; 

    public MarkCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        try{
            taskList.markDone(idx);
        } catch (MeowthException e){
            ui.getError(e);
        }
    }
}
