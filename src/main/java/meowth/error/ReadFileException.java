package meowth.error;

public class ReadFileException extends MeowthException{
    public ReadFileException(){
        super("Meowth doesn't see the text file!\nMeowth will create a new one for you meow~");
    }
}
