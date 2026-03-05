package meowth.save;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import meowth.error.MeowthException;
import meowth.error.ReadFileException;
import meowth.task.*;

/**
 * Handles serialization and deserialization of TaskList to/from text file.
 * Saves tasks in custom text format using "!" separator for parsing.
 * File format: "ToDo|name|true", "Deadline|name|true|byDate", "Event|name|true|from|to"
 */
public class FileSaver {
    
    /** Fixed filepath for task persistence. */
    private final static String FILEPATH = "saved_tasklist.txt";
    private final static String ESCAPECHAR = "~";

    /**
     * Serializes the task list to the fixed filepath.
     * Writes each task as a line with type, name, done status, and type-specific fields.
     * 
     * @param tasklist TaskList containing tasks to save
     * @throws IOException If file writing fails
     */
    public static void saveTaskList(TaskList tasklist) throws IOException{
        ArrayList<Task> tasks = tasklist.getTasks();
        String textToAdd = "";
        for (Task task: tasks){
            String line = "";
            if (task instanceof ToDo) {
                // line: "ToDo taskName true"
                line += "ToDo";
                line += ESCAPECHAR;
                line += task.getTaskName();
                line += ESCAPECHAR;
                line += String.valueOf(task.getDone());
                line += " \n";
            } else if (task instanceof Deadline){
                // line: "Deadline taskName true deadline"
                line += "Deadline";
                line += ESCAPECHAR;
                line += task.getTaskName();
                line += ESCAPECHAR;
                line += String.valueOf(task.getDone());
                line += ESCAPECHAR;
                line += Deadline.getDeadline();
                line += " \n";
            } else if (task instanceof Event){
                // line: "Event taskName true from to"
                line += "Event";
                line += ESCAPECHAR;
                line += task.getTaskName();
                line += ESCAPECHAR;
                line += String.valueOf(task.getDone());
                line += ESCAPECHAR;
                line += Event.getFrom();
                line += ESCAPECHAR;
                line += Event.getTo();
                line += " \n";
            }
            textToAdd += line;
        }
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write(textToAdd);
        fw.close();
    }

    /**
     * Deserializes tasks from file and adds them to the task list.
     * Parses each line by task type and reconstructs Task objects.
     * Prints import message on start.
     * 
     * @param tasklist TaskList to populate with loaded tasks
     * @throws MeowthException If file reading or parsing fails
     */
    public static void importTaskList(TaskList tasklist) throws MeowthException{
        File f = new File(FILEPATH); 
        try{
            System.out.println("Meowth is importing previous tasklist!");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                String line = s.nextLine().trim();
                String[] lineinputs = line.split(ESCAPECHAR);
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
            throw new ReadFileException();
        }
    }
}
