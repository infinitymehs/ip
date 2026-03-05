package meowth.command;
import meowth.task.TaskList;
import meowth.ui.Meowth;

public class HelpCommand extends Command{
    public HelpCommand(){
    }

    public void execute(TaskList taskList, Meowth ui){
        Meowth.printHelp();
    }
}
