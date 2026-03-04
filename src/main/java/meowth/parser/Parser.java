package meowth.parser;
import meowth.command.*;
import meowth.error.*;
import meowth.task.*;


public class Parser {
    public static Command parse(String fullInput) throws MeowthException{
        String[] inputs = fullInput.split(" ");
        String command = inputs[0].toLowerCase();
        String descriptor = "";
        for (int i = 1; i < inputs.length; i++) {
            descriptor += inputs[i];
            descriptor += " ";
        }
        switch(command){
        case "todo":
            if (inputs.length < 2){
                throw new InvalidInputException();
            } 
            String todoName = inputs[1].trim();
            if (todoName.length() == 0){
                throw new InvalidInputException();
            } else{
                ToDo newTodo = new ToDo(todoName);
                return new AddCommand(newTodo); 
            }
            
        case "deadline":
            String[] deadlineTemp = descriptor.split("/by");
            if (deadlineTemp.length < 2){
                throw new InvalidInputException();
            } 
            String deadlineName = deadlineTemp[0].trim();
            String deadlineBy = deadlineTemp[1].trim();
            if (deadlineName.length() == 0 || deadlineBy.length() == 0){
                throw new InvalidInputException();
            } else{
                Deadline newDeadline = new Deadline(deadlineName, deadlineBy);
                return new AddCommand(newDeadline);
            }
            
        case "event":
            String[] eventTemp = descriptor.split("/from");
            if (eventTemp.length < 2){
                throw new InvalidInputException();
            } 
            String eventName = eventTemp[0].trim();
            String[] eventTemp2 = eventTemp[1].split("/to");
            if (eventTemp2.length < 2){
                throw new InvalidInputException();
            } 
            String eventFrom = eventTemp2[0].trim();
            String eventTo = eventTemp2[1].trim();
            if (eventFrom.length() == 0 || eventTo.length() == 0 || eventName.length() == 0){
                throw new InvalidInputException();
            } else {
                Event newEvent = new Event(eventName, eventFrom, eventTo);
                return new AddCommand(newEvent);
            }
            
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
            throw new UnknownCommandException();
        }
        
    }
}
