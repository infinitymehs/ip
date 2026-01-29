import java.util.Scanner;
public class Meowth{
    static String line ="----------------------------------------";
    public static void startup(){
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
        System.out.println(line);
        System.out.println("Prepare for trouble! And make it double!");
        System.out.println("What can I do for you today?");
        System.out.println(line);
    }
    public static void end(){
        System.out.println("Team Rocket's blasting off againnnnnnn!");
        System.out.println(line);
    }
    public static void main(String[] args) {
        startup();
        boolean isRunning = true; 
        TaskList tasks = new TaskList();
        while (isRunning){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            String inputs[] = input.split(" ");

            // Breaks the loop and ends
            if (inputs[0].toLowerCase().compareTo("bye") == 0){
                end();
                isRunning = false;
                break;
            }

            else if (inputs[0].toLowerCase().compareTo("list") == 0){
                tasks.displayList();
            }

            // else if (inputs[0].toLowerCase().compareTo("mark") == 0){
            //     int idx = Integer.parseInt(inputs[1]);
            //     tasks.markDone(idx-1);
            // }
            // else if (inputs[0].toLowerCase().compareTo("unmark") == 0){
            //     int idx = Integer.parseInt(inputs[1]);
            //     tasks.markUndone(idx-1);
            // }
            else{
                tasks.addTask(input);
            }
            
            System.out.println(line);
        }
    }
}
