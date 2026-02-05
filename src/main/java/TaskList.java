public class TaskList {
    private Task[] tasks;
    private int numTask;

    public TaskList(){
        tasks = new Task[100];
        numTask = 0;
    }

    public void addTask(Task newTask){
        if (numTask < 100){
            tasks[numTask] = newTask;
            numTask++;
            System.out.println("Added: " + newTask.getTaskName());
            System.out.println(String.format("Now you have %d tasks in the list!", numTask));
        } else{
            System.out.println("Task list is full! Even Team Rocket isn't as busy :(");
        }
    }

    public void displayList(){
        String listLine = "%d. ";
        if (numTask == 0){
            System.out.println("List is empty, have you taken over the world?");
        } else{
            for (int i = 0; i < numTask; i++){
                System.out.print(String.format(listLine, i+1));
                tasks[i].printTask();
                System.out.print("\n");
            }
        }
    }

    public void markDone(int idx){
        if (idx < numTask){
            tasks[idx].setDone(true);
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks[idx].getTaskName()));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }

    public void markUndone(int idx){
        if (idx < numTask){
            tasks[idx].setDone(false);
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks[idx].getTaskName()));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }
}
