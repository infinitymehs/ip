package meowth.error;

public class EmptyTaskListException extends MeowthException {
    public EmptyTaskListException(){
        super("List is empty, have you taken over the world?");
    }
}
