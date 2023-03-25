package ir.ac.kntu;

public class Menu {

    private static Menu instance = new Menu();

    private Menu() {
    }

    public static Menu getInstance() {
        return instance;
    }

    public static void printTheMenu() {

        System.out.println("**************************************");
        System.out.println(" Menu:");
        System.out.println("1-Define a new airline");
        System.out.println("2-Define a flight");
        System.out.println("3-Print the list of airlines");
        System.out.println("4-Print the flights of an airline");
        System.out.println("5-Search for a flight");
        System.out.println("6-Reserve tickets");
        System.out.println("7-Cancel reservation");
        System.out.println("8-Complete reservation");
        System.out.println("9-Buy tickets");
        System.out.println("10-Cancel a ticket");
        System.out.println("11-View bill");
        System.out.println("12-EXIT");
        System.out.println("**************************************");
        System.out.print("\r\nPlease select your choice: ");

    }
    public Main.Option getOption() {
        Main.Option[] options = Main.Option.values();
        int userInput = ScannerWrapper.getInstance().nextInt();
        userInput--;
        if (userInput >= 0 && userInput < options.length) {
            return options[userInput];
        }
        return Main.Option.UNDEFINED;
    }
}
