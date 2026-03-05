package meowth.task;
import java.util.ArrayList;
import meowth.error.*;

/**
 * Manages the collection of tasks and provides operations to add, remove, and display tasks.
 * Enforces maximum capacity of 100 tasks and validates all index operations.
 * Handles all task list modifications and user feedback printing.
 */
public class TaskList {
    
    /** List of all tasks in the application. */
    private ArrayList<Task> tasks;
    
    /** Current number of tasks (maintained manually for display). */
    private int numTask;

    /**
     * Constructs an empty TaskList.
     * Initializes ArrayList and sets task count to zero.
     */
    public TaskList(){
        tasks = new ArrayList<>();
        numTask = 0;
    }

    /**
     * Returns the current number of tasks.
     * 
     * @return Number of tasks in the list
     */
    public int getNumTask(){
        return numTask;
    }

    /**
     * Returns the complete list of tasks.
     * 
     * @return ArrayList containing all tasks
     */
    public ArrayList<Task> getTasks(){
        return tasks;
    }

    /**
     * Adds a new task to the list if capacity allows.
     * Prints confirmation message with updated count.
     * 
     * @param newTask Task to add to the list
     * @throws MeowthException If list reaches 100 task maximum capacity
     */
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

    /**
     * Displays all tasks in numbered format.
     * Each task shows status icon, description, and type-specific details.
     * 
     * @throws MeowthException If list is empty
     */
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

    /**
     * Marks task at specified index as completed.
     * Prints confirmation with updated task display.
     * 
     * @param idx 0-based index of task to mark done
     * @throws MeowthException If index is out of bounds
     */
    public void markDone(int idx) throws MeowthException{
        if (idx < numTask){
            tasks.get(idx).setDone(true);
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks.get(idx).getTaskName()));
        } else {
            throw new InvalidIndexException();
        }
    }

    /**
     * Marks task at specified index as incomplete.
     * Prints confirmation with updated task display.
     * 
     * @param idx 0-based index of task to mark undone
     * @throws MeowthException If index is out of bounds
     */
    public void markUndone(int idx) throws MeowthException{
        if (idx < numTask){
            tasks.get(idx).setDone(false);
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks.get(idx).getTaskName()));
        } else {
            throw new InvalidIndexException();
        }
    }

    /**
     * Removes task at specified index from list.
     * Updates count and prints confirmation with new total.
     * 
     * @param idx 0-based index of task to delete
     * @throws MeowthException If index is out of bounds
     */
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

    /**
     * Finds and displays all tasks containing the search string.
     * Shows numbered list of matching tasks only.
     * 
     * @param stringToFind Keyword to search in task descriptions
     * @throws MeowthException If list is empty or no matches found
     */
    public void find(String stringToFind) throws MeowthException{
        if (numTask == 0){
            throw new EmptyTaskListException();
        } 
        ArrayList<Task> relevantTasks = new ArrayList<>();
        for (Task task: tasks){
            if (task.getTaskName().toLowerCase().contains(stringToFind.toLowerCase())){
                relevantTasks.add(task);
            }
        }
        if (relevantTasks.size() == 0){
            throw new NoRelevantTaskException();
        }
        String listLine = "%d. ";
        int count = 1;
        for (Task task: relevantTasks){
            System.out.print(String.format(listLine, count));
            task.printTask();
            System.out.print("\n");
            count++;
        }
    }
}
