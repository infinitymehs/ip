package meowth.error;
public class UnknownCommandException extends MeowthException{
    public UnknownCommandException(){
        super("Meowth doesn't understand the command!");
    }
}