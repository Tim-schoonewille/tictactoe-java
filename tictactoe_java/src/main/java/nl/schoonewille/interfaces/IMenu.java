package nl.schoonewille.interfaces;

import java.util.Scanner;

import nl.schoonewille.exceptions.InvalidMenuItemException;

public interface IMenu {

    void displayMenu();

    void executeMenuItem(char menuKey) throws InvalidMenuItemException;

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

}