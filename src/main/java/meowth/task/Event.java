public class Event extends Task {
    
    private String from;
    private String to; 

    public Event(String taskName, String from, String to){
        super(taskName);
        this.from = from;
        this.to = to;
    }

    public void printTask(){
        System.out.print("[E]");
        super.printTask();
        System.out.print(String.format("(from:%s to:%s)",from, to ));
    }
}
