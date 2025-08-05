package org.example;

public class HangmanStages {
    private static final String[] stages = {
            """
                                +—--—--+
                                |      |
                                |      O
                                |     /|\\
                                |     / \\
                                |
                                ===========
                                """,

            """
                                +—--—--+
                                |      |
                                |      O
                                |     /|\\
                                |     /
                                |
                                ===========
                                """,
            """
                                +—--—--+
                                |      |
                                |      O
                                |     /|\\
                                |
                                |
                                ===========
                                """,
            """
                                +—--—--+
                                |      |
                                |      O
                                |     /|
                                |
                                |
                                ===========
                                """,

            """
                                +—--—--+
                                |      |
                                |      O
                                |     /
                                |
                                |
                                ===========
                                """,


            """
                                +—--—--+
                                |      |
                                |      O
                                |
                                |
                                |
                                ===========
                                """,
            """
                                +—--—--+
                                |      |
                                |
                                |
                                |
                                |
                                ===========
                                """
    };

    public static String getStage(int index){
        return stages[index];
    }
}
