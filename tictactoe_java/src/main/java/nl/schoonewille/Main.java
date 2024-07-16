package nl.schoonewille;

import java.util.Scanner;

import nl.schoonewille.exceptions.QuitGameException;

public class Main {
    public static void main(String[] args) {

        TicTacToe ticTacToe = new TicTacToe(new Scanner(System.in));
        try {

            ticTacToe.run();
        } catch (QuitGameException e) {
            System.out.println("[+] Quiting game...");
        }
    }
}