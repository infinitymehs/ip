package meowth.command;
import java.io.IOException;
import meowth.task.TaskList;
import meowth.ui.Meowth;
import meowth.save.*;

public class ByeCommand extends Command{
    public ByeCommand(){
    }

    public void execute(TaskList taskList, Meowth ui){
        Meowth.printEnd();
        try {
            FileSaver.saveTaskList(taskList);
        } catch (IOException e) {
        }
        ui.setRunning(false);
    }
}
