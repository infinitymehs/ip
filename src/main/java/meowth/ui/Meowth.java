package meowth.ui;
import java.util.Scanner;
import meowth.error.*;
import meowth.task.*;
import meowth.save.*;
import meowth.command.*;
import meowth.parser.*;

/**
 * Main user interface class for the Meowth todo application.
 * Handles all user input/output, application lifecycle, and ASCII art display.
 * Contains the main method that orchestrates the entire application flow.
 */
public class Meowth {
    
    /** Horizontal line separator used throughout the UI. */
    public static final String LINE = "----------------------------------------";
    
    /** Controls the main application loop. */
    private boolean isRunning = true; 
    
    /** ASCII art logo displayed at application startup. */
    public static final String LOGO = "         .-. \\_/ .-.\r\n" + //
                    "         \\.-/\\/=-/.-/\r\n" + //
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

    /**
     * Returns the current running state of the application.
     * Used by main loop to determine whether to continue execution.
     * 
     * @return true if application should continue running
     */
    public boolean getRunning(){
        return isRunning;
    }

    /**
     * Sets the running state of the application.
     * Called by ByeCommand to exit the main loop gracefully.
     * 
     * @param isRunning true to continue running, false to exit
     */
    public void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    /**
     * Displays an error message to the user.
     * Called by commands when exceptions occur during execution.
     * 
     * @param e Exception containing the error message to display
     */
    public void getError(Exception e){
        System.out.println(e.getMessage());
    }

    /**
     * Prints the horizontal line separator.
     * Used between command outputs for visual separation.
     */
    public static void printLine(){
        System.out.println(LINE);
    }

    /**
     * Prints the startup welcome message with ASCII art logo.
     * Displays Team Rocket themed introduction and prompt.
     * Called once at application startup.
     */
    public static void printStart() {
        // credit to whoever made this on ascii art archive
        System.out.println(LOGO);
        System.out.println(LINE);
        System.out.println("Prepare for trouble! And make it double!");
        System.out.println("What can I do for you today?");
        System.out.println(LINE);
    }

    /**
     * Prints the goodbye message.
     * Team Rocket themed farewell displayed before application exit.
     * Called by ByeCommand during shutdown sequence.
     */
    public static void printEnd() {
        System.out.println("Team Rocket's blasting off againnnnnnn!");
    }

    /**
     * Prints the lists of possible commands
     * Called by HelpCommand when executed
     */
    public static void printHelp(){
        String HELPLINE = "Here are the list of commands: \n";
        HELPLINE += "help - displays the list of possible commands\n";
        HELPLINE += "list - displays the entire tasklist\n";
        HELPLINE += "todo <desc> - adds a todo task\n";
        HELPLINE += "deadline <desc> /by <date> - adds a deadline task\n";
        HELPLINE += "event <desc> /from <start> /to <end> - adds an event task\n";
        HELPLINE += "mark <index> - marks the task as done\n";
        HELPLINE += "unmark <index> - marks the task as undone\n";
        HELPLINE += "delete <index> - deletes the task\n";
        HELPLINE += "find <keyword> - displays tasks containing the keyword\n";
        HELPLINE += "bye - exits the program";
        System.out.println(HELPLINE);
    }

    /**
     * Main entry point for the Meowth todo application.
     * Initializes UI, loads tasks, and runs the command loop until bye command.
     * 
     * @param args Command line arguments (unused)
     */
    public static void main(String[] args) {
        printStart();
        Meowth ui =  new Meowth();
        TaskList tasks = new TaskList();
        Command importCommand = new ImportCommand();
        importCommand.execute(tasks, ui);
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
