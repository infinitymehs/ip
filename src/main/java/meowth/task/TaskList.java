package meowth.task;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import meowth.save.FileSaver;
import meowth.task.*;

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

    public void addTask(Task newTask){
        if (numTask < 100){
            tasks.add(newTask);
            numTask++;
            System.out.println("Added: " + newTask.getTaskName());
            System.out.println(String.format("Now you have %d tasks in the list!", numTask));
        } else {
            System.out.println("Task list is full! Even Team Rocket isn't as busy :(");
        }
    }

    public void displayList(){
        String listLine = "%d. ";
        if (numTask == 0){
            System.out.println("List is empty, have you taken over the world?");
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

    public void markDone(int idx){
        if (idx < numTask){
            tasks.get(idx).setDone(true);
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks.get(idx).getTaskName()));
        } else {
            System.out.println("Task does not exist!");
        }
    }

    public void markUndone(int idx){
        if (idx < numTask){
            tasks.get(idx).setDone(false);
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks.get(idx).getTaskName()));
        } else {
            System.out.println("Task does not exist!");
        }
    }

    public void delete(int idx){
        if (idx < numTask){
            tasks.remove(tasks.get(idx));
            numTask--;
            System.out.println("Got it! Deleted the task meow~");
            System.out.println(String.format("Now you have %d tasks in the list",numTask));
        } else {
            System.out.println("Task does not exist!");
        }
    }

}
