package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractGame implements Game{
    Integer sizeWord;
    String word;
    Integer maxTry;
    GameStatus gameStatus = GameStatus.OFF;
    static Integer countTry = 0;

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.setMaxTry(maxTry);
        this.setSizeWord(sizeWord);
        this.setWord(this.generateWord());
        this.setGameStatus(GameStatus.START);
        System.out.println("Начало игры!");
        System.out.printf("Отгадайте %d символа\n" , getSizeWord());
    }

    @Override
    public String generateWord() {
        List<String> charList = generateChatList();
        SecureRandom random = new SecureRandom();
        String res = "";
        for (int i = 0; i < sizeWord; i++) {
            res+= charList.get(random.nextInt(charList.size()));
        }
        return  res;
    }

    @Override
    public void inputAnswer(String value) {
        int bull = 0;
        int cow = 0;
        for (int i = 0; i < value.length(); i++) {
            Character temp = value.charAt(i);
            if (word.contains(temp.toString())){
                cow++;
            }
            if (i < this.getSizeWord() && value.charAt(i) == word.charAt(i)) {
                bull++;
            }
        }

        if (bull == sizeWord){
            this.setGameStatus(GameStatus.WIN);
            System.out.println("Победа! Вы отгадали слово!");
        }

        if (this.getGameStatus() == GameStatus.START){
            Answer answer = new Answer(cow, bull, value);
            answer.result();

            countTry++;
            if (countTry >= maxTry){
                this.setGameStatus(GameStatus.LOOSE);
                System.out.println("Попытки закончились, вы проиграли...");
                System.out.printf("Загаданное слово: %s\n", this.getWord());
            }
        }
    }

    abstract List<String> generateChatList ();

}
