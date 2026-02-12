package meowth.task;
public class Deadline extends Task{
    private String deadline;

    public Deadline(String taskName, String deadlineDate){
        super(taskName);
        deadline = deadlineDate;
    }

    public void printTask(){
        System.out.print("[D]");
        super.printTask();
        System.out.print(String.format("(by:%s)", deadline));
    }

}