package meowth.ui;
import java.util.Scanner;
import meowth.error.*;
import meowth.task.*;
import meowth.save.*;
import meowth.command.*;
import meowth.parser.*;

public class Meowth {
    public static final String LINE = "----------------------------------------";
    public boolean isRunning = true; 
    public static final String LOGO = "         .-. \\_/ .-.\r\n" + //
                                "         \\.-\\/=\\/.-/\r\n" + //
                                "      '-./___|=|___\\.-'\r\n" + //
                                "     .--| \\|/`\"`\\|/ |--.\r\n" + //
                                "    (((_)\\  .---.  /(_)))\r\n" + //
                                "     `\\ \\_`-.   .-'_/ /`_\r\n" + //
                                "       '.__       __.'(_))\r\n" + //
                                "           /     \\     //\r\n" + //
                                "          |       |.'__/\r\n" + //
                                "          \\       /--'`\r\n" + //
                                "      .--,-' .--. '----.\r\n" + //
                                "     '----`--'  '--`----'";

    public boolean getRunning(){
        return isRunning;
    }

    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void getError(MeowthException e){
        System.out.println(e.getMessage());
    }

    public static void printLine(){
        System.out.println(LINE);
    }

    public static void printStart() {
        // credit to whoever made this on ascii art archive
        System.out.println(LOGO);
        System.out.println(LINE);
        System.out.println("Prepare for trouble! And make it double!");
        System.out.println("What can I do for you today?");
        System.out.println(LINE);
    }

    public static void printEnd() {
        System.out.println("Team Rocket's blasting off againnnnnnn!");
    }

    public static void main(String[] args) {

        printStart();
        Meowth ui =  new Meowth();
        TaskList tasks = new TaskList();
        try{
            FileSaver.importTaskList(tasks);
        } catch (MeowthException e){
            ui.getError(e);
        }
        printLine();


        Scanner in = new Scanner(System.in);
        while (ui.getRunning()) {
            String input = in.nextLine();
            try {
                Command newCommand = Parser.parse(input);
                newCommand.execute(tasks,ui);
            } catch (MeowthException e){
                ui.getError(e);
            }
            System.out.println(LINE);
        }
    }
}
