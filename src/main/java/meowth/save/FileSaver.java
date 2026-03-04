package meowth.save;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import meowth.task.*;

public class FileSaver {
    private final static String FILEPATH = "saved_tasklist.txt";

    public static void saveTaskList(TaskList tasklist) throws IOException{
        ArrayList<Task> tasks = tasklist.getTasks();
        File f = new File(FILEPATH);
        String textToAdd = "";
        String INPUTSEPARATOR = "!";
        for (Task task: tasks){
            String line = "";
            if (task instanceof ToDo) {
                // line: "ToDo taskName true"
                line += "ToDo";
                line += INPUTSEPARATOR;
                line += task.getTaskName();
                line += INPUTSEPARATOR;
                line += String.valueOf(task.getDone());
                line += " \n";
            } else if (task instanceof Deadline){
                // line: "Deadline taskName true deadline"
                line += "Deadline";
                line += INPUTSEPARATOR;
                line += task.getTaskName();
                line += INPUTSEPARATOR;
                line += String.valueOf(task.getDone());
                line += INPUTSEPARATOR;
                line += Deadline.getDeadline();
                line += " \n";
            } else if (task instanceof Event){
                // line: "Event taskName true from to"
                line += "Event";
                line += INPUTSEPARATOR;
                line += task.getTaskName();
                line += INPUTSEPARATOR;
                line += String.valueOf(task.getDone());
                line += INPUTSEPARATOR;
                line += Event.getFrom();
                line += INPUTSEPARATOR;
                line += Event.getTo();
                line += " \n";
            }
            textToAdd += line;
        }
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write(textToAdd);
        fw.close();
    }

    public static void importTaskList(TaskList tasklist){
        File f = new File(FILEPATH); 
        try{
            System.out.println("Meowth is importing previous tasklist!");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine().trim();
                String[] lineinputs = line.split("!");
                switch (lineinputs[0]){
                case "ToDo":
                    ToDo newTask1 = new ToDo(lineinputs[1]);
                    switch (lineinputs[2].trim()){
                    case "true":
                        newTask1.setDone(true);
                        break;
                    case "false":
                        break;
                    }
                    tasklist.addTask(newTask1);
                    break;
                case "Deadline":
                    Deadline newTask2 = new Deadline(lineinputs[1], lineinputs[3]);
                    switch (lineinputs[2].trim()){
                    case "true":
                        newTask2.setDone(true);
                        break;
                    case "false":
                        break;
                    }
                    tasklist.addTask(newTask2);
                    break;
                case "Event": 
                    Event newTask3 = new Event(lineinputs[1], lineinputs[3], lineinputs[4]);
                    switch (lineinputs[2].trim()){
                    case "true":
                        newTask3.setDone(true);
                        break;
                    case "false":
                        break;
                    }
                    tasklist.addTask(newTask3);
                    break;
                }
            }
        } catch (Exception e){
        }
        
    }
}
