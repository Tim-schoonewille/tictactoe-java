package nl.schoonewille;

import java.util.Scanner;

import nl.schoonewille.engine.TicTacToeEngine;
import nl.schoonewille.exceptions.QuitGameException;
import nl.schoonewille.interfaces.IMenu;
import nl.schoonewille.models.Player;
import nl.schoonewille.utils.menu.Menu;
import nl.schoonewille.utils.menu.MenuItem;

public class TicTacToe {

    private Scanner scanner;
    private IMenu mainMenu;
    private Player mainPlayer;

    public static void quitGame() {
        throw new QuitGameException("bye");
    }

    public TicTacToe(Scanner scanner) {
        this.scanner = scanner;
        MenuItem pvpMenuItem = new MenuItem('1', "Player versus Player",
                () -> playerVersusPlayer());
        MenuItem vsCpuMenuItem = new MenuItem('2', "Player vs CPU",
                () -> IMenu.notImplemented());
        MenuItem multiplayerMenuItem = new MenuItem('3', "Multiplayer",
                () -> IMenu.notImplemented());
        MenuItem changePlayerMenuItem = new MenuItem('4', "Change Player",
                () -> IMenu.notImplemented());
        MenuItem helpMenuItem = new MenuItem('5', "Help", () -> IMenu.notImplemented());
        MenuItem quitMenuItem = new MenuItem('6', "Quit", () -> quitGame());
        mainMenu = new Menu("Main menu", pvpMenuItem, vsCpuMenuItem, multiplayerMenuItem,
                changePlayerMenuItem, helpMenuItem, quitMenuItem);
        mainPlayer = new Player(getPlayerName(scanner));

    }

    private String getPlayerName(Scanner scanner) {
        String input = null;
        while (input == null || input == "") {
            System.out.println("What is your name?");
            input = scanner.nextLine();
        }
        return input;
    }

    private void playerVersusPlayer() {
        Player playerTwo = new Player(getPlayerName(scanner));
        var game = new TicTacToeEngine(scanner, mainPlayer, playerTwo);
        game.run();

    }

    public void run() {
        mainMenu.run(scanner);
    }
}