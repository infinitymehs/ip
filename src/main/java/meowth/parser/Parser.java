package meowth.parser;
import meowth.command.*;
import meowth.error.*;
import meowth.task.*;


public class Parser {
    public static Command parse(String fullInput){
        String[] inputs = fullInput.split(" ");
        String command = inputs[0].toLowerCase();
        String descriptor = "";
        for (int i = 1; i < inputs.length; i++) {
            descriptor += inputs[i];
            descriptor += " ";
        }
        switch(command){

        case "todo":
            String todoName = inputs[1].trim();
            ToDo newTodo = new ToDo(todoName);
            return new AddCommand(newTodo); 

        case "deadline":
            String[] temp = descriptor.split("/by");
            Deadline newDeadline = new Deadline(temp[0].trim(), temp[1].trim());
            return new AddCommand(newDeadline);

        case "event":
            String[] eventTemp = descriptor.split("/from");
            String eventName = eventTemp[0].trim();
            String[] eventTemp2 = eventTemp[1].split("/to");
            Event newEvent = new Event(eventName, eventTemp2[0].trim(), eventTemp2[1].trim());
            return new AddCommand(newEvent);

        case "mark":
            int markIdx = Integer.parseInt(inputs[1]);
            return new MarkCommand(markIdx - 1);

        case "unmark":
            int unmarkIdx = Integer.parseInt(inputs[1]);
            return new UnmarkCommand(unmarkIdx - 1);

        case "delete":
            int deleteIdx = Integer.parseInt(inputs[1]);
            return new DeleteCommand(deleteIdx - 1);

        case "list":
            return new ListCommand();

        case "bye":
            return new ByeCommand();

        default: 
            return new ErrorCommand();
        }
        
    }
}
