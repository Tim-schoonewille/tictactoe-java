package nl.schoonewille.interfaces;

import java.util.Scanner;

import nl.schoonewille.exceptions.InvalidMenuItemException;

public interface IMenu {

    void displayMenu();

    void executeMenuItem(char menuKey) throws InvalidMenuItemException;

    void run(Scanner scanner);

    public static void getMenuItemFromUser(Scanner scanner, IMenu menu) {
        char input;
        System.out.println("Insert your option: ");
        while (true) {
            input = scanner.nextLine().charAt(0);

            try {
                menu.executeMenuItem(input);
                break;
            } catch (InvalidMenuItemException e) {
                System.out.println("Invalid key...");
            }
        }
    }

    public static void notImplemented() {
        System.out.println("Not yet implemented...");
    }
}