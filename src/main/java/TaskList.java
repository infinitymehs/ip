public class TaskList {
    private String[] tasks;
    private boolean[] taskStatuses;
    private int numTask;

    public TaskList(){
        tasks = new String[100];
        numTask = 0;
        taskStatuses = new boolean[100];
    }

    public void addTask(String task){
        if (numTask < 100){
            tasks[numTask] = task;
            taskStatuses[numTask] = false;
            numTask++;
            System.out.println("Added: " + task);
        } else{
            System.out.println("Task list is full! Even Team Rocket isn't as busy :(");
        }
    }

    public void displayList(){
        String listLine = "%d.[%s] %s";
        if (numTask == 0){
            System.out.println("List is empty, have you taken over the world?");
        } else{
            for (int i = 0; i < numTask; i++){
                char status = ' ';
                if (taskStatuses[i] == true){
                    status = 'X';
                }
                System.out.println(String.format(listLine, i+1, status, tasks[i]));
            }
        }
    }

    public void markDone(int idx){
        if (idx < numTask){
            taskStatuses[idx] = true;
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks[idx]));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }

    public void markUndone(int idx){
        if (idx < numTask){
            taskStatuses[idx] = false;
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks[idx]));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }
}
