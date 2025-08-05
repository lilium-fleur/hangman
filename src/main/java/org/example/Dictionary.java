package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dictionary {
    private static final int MAX_WORD_LENGTH = 6;
    private List<String> words = new ArrayList<>();
    private final String path;

    public Dictionary(String path) {
        this.path = path;
        try{
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                String word = scanner.nextLine();
                if(word.length() <= MAX_WORD_LENGTH) {
                    words.add(word);
                }
            }
            scanner.close();
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Не удалось загрузить словарь: %s. Проверьте ресурс по пути: %s", e.getMessage(), path));
        }
    }

    public String popRandom() {
        int maxLength = words.size() - 1;
        if(maxLength == 0){
            throw new RuntimeException(String.format("Список слов пусть, проверьте ресурс по пути: %s", path));
        }
        return words.remove(ThreadLocalRandom.current().nextInt(maxLength));
    }
}

