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

}