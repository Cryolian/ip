import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import command.UserInput;
import command.Database;
import task.Task;

public class John {

    private static List<Task> taskList = new ArrayList<>();

    public static void main(String[] args) {

        printWelcomeMessage();
        readData();

        Scanner in = new Scanner(System.in);
        String userInput = in.next();

        while (!userInput.equalsIgnoreCase("bye")) {
            UserInput.parseInput(userInput, in, taskList);
            userInput = in.next();
            System.out.println("");
        }

        storeData();
        printExitMessage();

    }

    private static void storeData() {
        try {
            Database.storeData(taskList);
        } catch (IOException e) {
            System.out.println("Error storing data.");
        }
    }

    private static void readData() {
        try {
            Database.readData(taskList);
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found");
        }
    }

    private static void printExitMessage() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    private static void printWelcomeMessage() {
        System.out.println("Hello! I'm John Chadbot.\n" + "What can I do for you?\n");
    }
}
