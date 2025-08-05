package org.example;

public class MaskedWord {
    private String targetWord;
    private StringBuilder mask;

    public MaskedWord(String targetWord) {
        this.targetWord = targetWord;
        this.mask = targetWord == null ? new StringBuilder() : new StringBuilder("_".repeat(targetWord.length()));
    }

    public String getTargetWord() {
        return targetWord;
    }

    public StringBuilder getMask() {
        return mask;
    }

    public boolean openLetter(char inputLetter) {
        int letterIndex = targetWord.indexOf(inputLetter);

        if (letterIndex == -1) return false;

        while (letterIndex >= 0) {
            mask.setCharAt(letterIndex, inputLetter);
            letterIndex = targetWord.indexOf(inputLetter, letterIndex + 1);
        }
        return true;
    }

    public boolean isTargetEqualsMask(){
        return targetWord.contentEquals(mask);
    }
}
