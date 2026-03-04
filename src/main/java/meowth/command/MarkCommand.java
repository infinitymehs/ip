package meowth.command;
import meowth.task.*;
import meowth.ui.Meowth;

public class MarkCommand extends Command {
    private int idx; 

    public MarkCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        taskList.markDone(idx);
    }
}
