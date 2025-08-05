package org.example;

import java.util.Set;

public class ConsolePrinter {

    public static void printMenu(String restartCommand, String exitCommand) {
        System.out.printf("Введите \"%s\" чтобы начать новую игру, для выхода \"%s\"%n",
                restartCommand, exitCommand);
        System.out.print("Ожидание ввода... -> ");
    }


    public static void printProcessedGuess(
            String exitCommand, StringBuilder maskedWord, int attempts, Set<Character> usedLetters) {
        System.out.println("__________________________________");
        System.out.printf("Для выхода в главное меню введите \"%s\"%n", exitCommand);
        System.out.printf("Отгадайте слово: %s%n", maskedWord);
        System.out.printf("Использованы буквы: %s%n", usedLetters.toString());
        System.out.println(HangmanStages.getStage(attempts));
        System.out.printf("До поражения осталось ошибок: %d%n", attempts);
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printVictory(String word) {
        System.out.println("\n__________________________________");
        System.out.printf("Поздравляем, вы отгадали слово \"%s\" %n%n", word);
    }

    public static void printDefeat(String word) {
        System.out.println("\n__________________________________");
        System.out.println("\nВы проиграли!");
        System.out.printf("Было загаданно слово: \"%s\" %n%n", word);
    }

    public static void printValidationException() {
        System.out.println("__________________________________");
        System.out.println("Ошибка! Принимаются только одиночные буквы русского алфавита");
        System.out.print("Ожидание ввода... -> ");
    }

    public static void printErrorMessage(String message) {
        System.out.println("__________________________________");
        System.out.printf("Ошибка! %s%n", message);
    }
}
