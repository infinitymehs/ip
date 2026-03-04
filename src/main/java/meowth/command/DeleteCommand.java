package meowth.command;
import meowth.task.*;
import meowth.ui.Meowth;

public class DeleteCommand extends Command {
    private int idx;

    public DeleteCommand(int idx){
        this.idx = idx;
    }

    public void execute(TaskList taskList, Meowth ui){
        taskList.delete(idx);
    }
}
