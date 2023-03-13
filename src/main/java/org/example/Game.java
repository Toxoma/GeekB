package org.example;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    String generateWord();

    void inputAnswer(String value);

    GameStatus getGameStatus();
}
