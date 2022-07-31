import commands.CommandMissingException;
import commands.InterruptAppException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            menu.printMenu();
            int command = scanner.nextInt();
            try {
                menu.executeCommand(command);
            } catch (CommandMissingException exception) {
                System.out.println(exception.getMessage());
            } catch (InterruptAppException exception) {
                break;
            }
        }
    }
}

