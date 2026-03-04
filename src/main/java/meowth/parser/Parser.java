package meowth.parser;
import meowth.command.*;
import meowth.error.*;
import meowth.task.*;


public class Parser {
    public static Command parse(String fullInput) throws MeowthException{
        String[] inputs = fullInput.split(" ",2);
        String command = inputs[0].toLowerCase();
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
            String[] deadlineTemp = inputs[1].split("/by");
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
            String[] eventTemp = inputs[1].split("/from");
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

        case "find":
            if (inputs.length < 2){
                throw new InvalidInputException();
            }
            String stringToFind = inputs[1].trim();
            return new FindCommand(stringToFind);

        case "list":
            return new ListCommand();

        case "bye":
            return new ByeCommand();

        default: 
            throw new UnknownCommandException();
        }
        
    }
}
