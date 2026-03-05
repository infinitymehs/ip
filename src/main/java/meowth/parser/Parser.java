package meowth.parser;
import meowth.command.*;
import meowth.error.*;
import meowth.task.*;

/**
 * Parses raw user input strings into appropriate Command objects.
 * Supports todo, deadline, event, mark, unmark, delete, find, list, and bye commands.
 * Throws exceptions for invalid input formats.
 */
public class Parser {
    
    /**
     * Converts user input into a Command object for execution.
     * Uses switch statement to recognize command type and extract arguments.
     * 
     * @param fullInput Raw user input string from UI (e.g. "todo buy milk", "delete 1")
     * @return Command object ready for execution via polymorphism
     * @throws MeowthException If command is unknown or input format is invalid
     * @throws InvalidInputException For missing descriptions, malformed deadlines/events, or invalid indices
     * @throws UnknownCommandException For unrecognized command words
     * @throws InvalidIndexException When the index is too large/small for the task lists
     */
    public static Command parse(String fullInput) throws MeowthException{
        String[] inputs = fullInput.split(" ",2);
        String command = inputs[0].toLowerCase();
        switch(command){
        case "help":
            return new HelpCommand();
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
            if (inputs.length < 2){
                throw new InvalidInputException();
            } 
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
            if (inputs.length < 2){
                throw new InvalidInputException();
            } 
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
            if (inputs.length < 2){
                throw new InvalidInputException();
            }
            int markIdx = Integer.parseInt(inputs[1]);
            return new MarkCommand(markIdx - 1);

        case "unmark":
            if (inputs.length < 2){
                throw new InvalidInputException();
            }
            int unmarkIdx = Integer.parseInt(inputs[1]);
            return new UnmarkCommand(unmarkIdx - 1);

        case "delete":
            if (inputs.length < 2){
                throw new InvalidInputException();
            }
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
