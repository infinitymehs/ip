package meowth.task;
public class ToDo extends Task{

    public ToDo(String taskName){
        super(taskName);
    }

    public void printTask(){
        System.out.print("[T]");
        super.printTask();
    }
}