package meowth.error;

public class FullTaskListException extends MeowthException {
    public FullTaskListException(){
        super("Task list is full! Even Team Rocket isn't as busy :(");
    }
}
