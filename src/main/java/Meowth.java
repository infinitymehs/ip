import java.util.Scanner;
public class Meowth{
    static String LINE ="----------------------------------------";
    public static void printStart(){
        // credit to whoever made this on ascii art archive
        String logo = "         .-. \\_/ .-.\r\n" + //
                        "         \\.-\\/=\\/.-/\r\n" + //
                        "      '-./___|=|___\\.-'\r\n" + //
                        "     .--| \\|/`\"`\\|/ |--.\r\n" + //
                        "    (((_)\\  .---.  /(_)))\r\n" + //
                        "     `\\ \\_`-.   .-'_/ /`_\r\n" + //
                        "       '.__       __.'(_))\r\n" + //
                        "           /     \\     //\r\n" + //
                        "          |       |__.'/\r\n" + //
                        "          \\       /--'`\r\n" + //
                        "      .--,-' .--. '----.\r\n" + //
                        "     '----`--'  '--`----'";
        System.out.println(logo);
        System.out.println(LINE);
        System.out.println("Prepare for trouble! And make it double!");
        System.out.println("What can I do for you today?");
        System.out.println(LINE);
    }
    public static void printEnd(){
        System.out.println("Team Rocket's blasting off againnnnnnn!");
        System.out.println(LINE);
    }
    public static void main(String[] args) {
        printStart();
        boolean isRunning = true; 
        TaskList tasks = new TaskList();
        while (isRunning){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String inputs[] = input.split(" ");

            // Case 1: If the user ends the chat
            if (inputs[0].toLowerCase().compareTo("bye") == 0){
                // Print the end dialogue and breaks out of the while loop 
                printEnd();
                isRunning = false;
                break;
            // Case 2: If the user wants to check their list
            } else if (inputs[0].toLowerCase().compareTo("list") == 0 && inputs.length == 1){
                // Calls the TaskList object displayList() method
                tasks.displayList();
            // Case 3: If the user wants to mark a task as done
            } else if (inputs[0].toLowerCase().compareTo("mark") == 0){
                // Uses a try catch statement to ensure that the index is valid 
                // (if there is index / it is a digit)
                try{
                    int idx = Integer.parseInt(inputs[1]);
                    tasks.markDone(idx-1);
                } catch (Exception e){
                    System.out.println("Index invalid!");
                }
            // Case 4: If the user wants to unmark a task as done
            } else if (inputs[0].toLowerCase().compareTo("unmark") == 0){
                // Uses a try catch statement to ensure that the index is valid 
                // (if there is index / it is a digit)
                try{
                    int idx = Integer.parseInt(inputs[1]);
                    tasks.markUndone(idx-1);
                } catch (Exception e){
                    System.out.println("Index invalid!");
                }
            // If not, add the user's input as a task 
            } else{
                tasks.addTask(input);
            }
            
            System.out.println(LINE);
        }
    }
}
