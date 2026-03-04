package meowth.error;

public class InvalidInputException extends MeowthException {
    public InvalidInputException(){
        super("Meowth does not understand your inputs!");
    }
}
