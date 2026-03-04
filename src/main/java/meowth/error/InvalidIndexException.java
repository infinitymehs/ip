package meowth.error;

public class InvalidIndexException extends MeowthException{
    public InvalidIndexException(){
        super("Meowth can't reach that task, index is incorrect!");
    }
}
