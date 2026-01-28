public class Meowth{
    static String line ="----------------------------------------";
    public static void startup(){
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
        // credit to whoever made this on ascii art archive
        startup();
        end();
    }
}
