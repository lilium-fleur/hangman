package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Dictionary dictionary = new Dictionary("src/main/resources/words.txt");
            Game game = new Game(dictionary);
            game.startGameLoop();
        } catch (Exception e) {
            ConsolePrinter.printErrorMessage(e.getMessage());
        }
    }
}