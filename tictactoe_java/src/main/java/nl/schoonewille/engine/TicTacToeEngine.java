package nl.schoonewille.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import nl.schoonewille.models.Player;

public class TicTacToeEngine {

    private List<Player> players;
    private Scanner scanner;
    private int currentRound;
    private Board board;
    private Player currentWinner;
    private char[] characters = { 'X', 'O' };

    public TicTacToeEngine(Scanner scanner, Player p1, Player p2) {
        this.scanner = scanner;
        players = new ArrayList<>(List.of(p1, p2));
        board = new Board();
        this.currentWinner = null;
    }

    private String getInput(String display) {
        String input = null;
        while (input == null || input == "") {
            System.out.println(display);
            input = scanner.nextLine();
        }
        return input;
    }

    private void startGame() {
        board.resetBoard();
        currentRound = 0;
        System.out.println("Welcome to tic tac toe!\n");
        System.out.println("This round will be " + players.get(0).getName() + " vs "
                + players.get(1).getName() + "\n");

        displayScores();
        while (currentRound < 9) {

            nextRound();
            if (calculateWinner()) {
                break;
            }

        }

        board.displayBoard();
        showWinner();
        currentWinner.setCurrentScore(currentWinner.getHighScore() + 1);
    }

    private void showWinner() {
        if (currentWinner == null) {
            System.out.println("It's a draw! ");
            return;
        }
        System.out.println("Winner is:");
        System.out.println(currentWinner.getName());

    }

    private void nextRound() {
        currentRound++;
        displayCurrentRound();
        board.displayBoard();

        newPlayerMove();

    }

    private void newPlayerMove() {

        int column;
        int row;

        while (true) {

            String input = getInput("Your next move: ");

            try {
                row = Integer.parseInt(input.substring(0, 1));
                column = Integer.parseInt(input.substring(1, 2));

            } catch (Exception e) {
                continue;
            }

            if (row < 0 || row > 2 || column < 0 || column > 2)
                continue;

            int charIndex = (currentRound - 1) % 2;
            char character = characters[charIndex];
            if (board.setToBoard(row, column, character)) {
                break;
            }
        }

    }

    private void displayCurrentRound() {
        System.out.println("Current round: " + currentRound);
        System.out.format("Current player: %s with char: %c%n",
                players.get((currentRound - 1) % 2).getName(),
                characters[(currentRound - 1) % 2]);
        System.out.println();
    }

    private boolean calculateWinner() {

        char[][] fields = board.getFields();
        boolean isWinner = false;
        for (int i = 0; i < 3; i++) {
            if (fields[i][0] == fields[i][1] && fields[i][1] == fields[i][2]
                    && fields[i][0] != '_') {
                isWinner = true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (fields[0][i] == fields[1][i] && fields[1][i] == fields[2][i]
                    && fields[0][i] != '_') {
                isWinner = true;
            }
        }

        if (fields[0][0] == fields[1][1] && fields[1][1] == fields[2][2]
                && fields[0][0] != '_') {
            isWinner = true;
        }

        if (fields[0][2] == fields[1][1] && fields[1][1] == fields[2][0]
                && fields[0][2] != '_') {
            isWinner = true;
        }

        if (isWinner) {

            currentWinner = players.get((currentRound - 1) % 2);
            return true;
        }

        return false;
    }

    private void displayScores() {
        System.out.println("Current scores: ");
        Player p1 = players.get(0);
        Player p2 = players.get(1);
        System.out.println(p1.getName() + ": " + p1.getCurrentScore());
        System.out.println(p2.getName() + ": " + p2.getCurrentScore());
        System.out.println();

    }

    public void run() {
        while (true) {
            startGame();

            if (getInput("Play again? Y / N").charAt(0) == 'N')
                break;
        }
    }
}
