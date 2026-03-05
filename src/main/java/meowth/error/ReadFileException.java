package meowth.error;

/**
 * Exception thrown when file reading or import operation fails.
 * Occurs when saved_tasklist.txt cannot be found or parsed during startup.
 */
public class ReadFileException extends MeowthException{
    
    /**
     * Constructs a ReadFileException with file access error message.
     * Informs user that no saved file exists and a new one will be created.
     */
    public ReadFileException(){
        super("Meowth doesn't see the text file!\nMeowth will create a new one for you meow~");
    }
}
