public class TaskList {
    private Task[] tasks;
    private int numTask;

    public TaskList(){
        tasks = new Task[100];
        numTask = 0;
    }

    public void addTask(String task){
        if (numTask < 100){
            Task newTask = new Task(task);
            tasks[numTask] = newTask;
            numTask++;
            System.out.println("Added: " + newTask.getTaskName());
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
                if (tasks[i].getIsDone() == true){
                    status = 'X';
                }
                System.out.println(String.format(listLine, i+1, status, tasks[i].getTaskName()));
            }
        }
    }

    public void markDone(int idx){
        if (idx < numTask){
            tasks[idx].setIsDone(true);
            System.out.println("This task is marked as done! Out of the way!");
            System.out.println(String.format("[X] %s",tasks[idx].getTaskName()));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }

    public void markUndone(int idx){
        if (idx < numTask){
            tasks[idx].setIsDone(false);
            System.out.println("This task is marked as undone :(");
            System.out.println(String.format("[ ] %s",tasks[idx].getTaskName()));
        }
        else{
            System.out.println("Task does not exist!");
        }
    }
}
