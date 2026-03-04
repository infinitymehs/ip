package meowth.command;
import meowth.task.*;
import meowth.ui.*;

public class ErrorCommand extends Command{
    public ErrorCommand(){

    }

    public void execute(TaskList taskList, Meowth ui){
        System.out.println("Something went wrong, please try again");
    }
}
