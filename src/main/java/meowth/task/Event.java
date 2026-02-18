package meowth.task;
public class Event extends Task {
    
    private static String from;
    private static String to; 

    public Event(String taskName, String from, String to){
        super(taskName);
        this.from = from;
        this.to = to;
    }

    public static String getFrom(){
        return from;
    }

    public static String getTo(){
        return to;
    }

    public void printTask(){
        System.out.print("[E]");
        super.printTask();
        System.out.print(String.format("(from:%s to:%s)",from, to ));
    }
}
