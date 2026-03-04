package meowth.task;
import java.util.ArrayList;
import meowth.error.*;

public class TaskList {
    private ArrayList<Task> tasks;
    private int numTask;

    public TaskList(){
        tasks = new ArrayList<>();
        numTask = 0;
    }

    public int getNumTask(){
        return numTask;
    }

    public ArrayList<Task> getTasks(){
        return tasks;
    }

    public void addTask(Task newTask) throws MeowthException{
        if (numTask < 100){
            tasks.add(newTask);
            numTask++;
            System.out.println("Added: " + newTask.getTaskName());
            System.out.println(String.format("Now you have %d tasks in the list!", numTask));
        } else {
            throw new FullTaskListException();
        }
    }

    public void displayList() throws MeowthException{
        String listLine = "%d. ";
        if (numTask == 0){
            throw new EmptyTaskListException();
        } else {
            int count = 1;
            for (Task task: tasks){
                System.out.print(String.format(listLine, count));
                task.printTask();
                System.out.print("\n");
                count++;
            }
        }
    }

    public void markDone(int idx) throws MeowthException{
        if (idx < numTask){
            tasks.get(idx).setDone(true);
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks.get(idx).getTaskName()));
        } else {
            throw new InvalidIndexException();
        }
    }

    public void markUndone(int idx) throws MeowthException{
        if (idx < numTask){
            tasks.get(idx).setDone(false);
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks.get(idx).getTaskName()));
        } else {
            throw new InvalidIndexException();
        }
    }

    public void delete(int idx) throws MeowthException{
        if (idx < numTask){
            tasks.remove(tasks.get(idx));
            numTask--;
            System.out.println("Got it! Deleted the task meow~");
            System.out.println(String.format("Now you have %d tasks in the list",numTask));
        } else {
            throw new InvalidIndexException();
        }
    }

}
