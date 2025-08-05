package org.example;

import java.util.*;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Dictionary dictionary;

    private static final String EXIT_COMMAND = "0";
    private static final String RESTART_COMMAND = "1";
    private static final String EXIT_TO_MENU_COMMAND = "2";
    private static final int INITIAL_ATTEMPTS = 6;

    public Game(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void startGameLoop() {
        boolean isGameOver = false;
        while (!isGameOver) {
            ConsolePrinter.printMenu(RESTART_COMMAND, EXIT_COMMAND);
            String input = scanner.nextLine();
            switch (input) {
                case EXIT_COMMAND:
                    isGameOver = true;
                    System.exit(0);
                case RESTART_COMMAND:
                    startGameRound();
                    continue;
                default: {
                    ConsolePrinter.printErrorMessage("Некорректный символ.");
                    break;
                }
            }
        }

    }

    public void startGameRound() {
        MaskedWord maskedWord = new MaskedWord(dictionary.popRandom());
        int attempts = INITIAL_ATTEMPTS;
        Set<Character> incorrectLetters = new HashSet<>();
        ConsolePrinter.printProcessedGuess(EXIT_TO_MENU_COMMAND, maskedWord.getMask(), attempts, incorrectLetters);

        while (attempts > 0){
            String input = scanner.nextLine();

            if(input.equals(EXIT_TO_MENU_COMMAND)) return;

            if (!Validator.isValid(input)) {
                ConsolePrinter.printValidationException();
                continue;
            }

            char letter = input.toLowerCase().charAt(0);

            if (maskedWord.openLetter(letter)){
                ConsolePrinter.printProcessedGuess(
                        EXIT_TO_MENU_COMMAND, maskedWord.getMask(), attempts, incorrectLetters);
            } else {
                if (!incorrectLetters.contains(letter)) {
                    incorrectLetters.add(letter);
                    attempts--;
                }
                ConsolePrinter.printProcessedGuess(
                        EXIT_TO_MENU_COMMAND, maskedWord.getMask(), attempts, incorrectLetters);
            }

            checkGameRoundState(attempts, maskedWord);
        }

    }


    private void checkGameRoundState(int attempts, MaskedWord maskedWord) {
        if (attempts > 0 && maskedWord.isTargetEqualsMask()) {
            ConsolePrinter.printVictory(maskedWord.getTargetWord());
        } else if (attempts <= 0 && !maskedWord.isTargetEqualsMask()) {
            ConsolePrinter.printDefeat(maskedWord.getTargetWord());
        }
    }


}
