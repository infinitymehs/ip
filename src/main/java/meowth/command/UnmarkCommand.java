package meowth.command;
import meowth.task.*;
import meowth.ui.Meowth;

public class UnmarkCommand extends Command {
    private int idx; 

    public UnmarkCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        taskList.markUndone(idx);
    }
}
