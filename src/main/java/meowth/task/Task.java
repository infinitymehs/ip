package meowth.task;
public class Task{
    private String taskName;
    private boolean isDone;

    public Task(String taskName){
        this.taskName = taskName;
        isDone = false;
    }

    public String getTaskName(){
        return taskName;
    }

    public boolean getDone(){
        return isDone;
    }

    public void setDone(boolean toSet){
        isDone = toSet;
    }

    public void printTask(){
        String done = " ";
        if (isDone){
            done = "X";
        }
        String listLine = "[%s] %s";
        System.out.print(String.format(listLine, done, taskName));
    }

}