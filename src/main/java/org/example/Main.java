package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите тип игры:\n1) Цифры\n2) Рус\n3) Англ");
        History history = new History();
        System.out.print("Ваш выбор: ");
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        Integer temp1 = scanner.nextInt();
        history.addAction(String.valueOf(temp1));
        switch (temp1){
            case 1:
                game = new NumberGame();
                break;
            case 2:
                game = new WordRusGame();
                break;
            case 3:
                game = new WordEngGame();
                break;
            default:
                System.out.println("Нет такой игры!");
        }
        game.start(4,2);
        scanner.nextLine();
        String temp2 = "";
        while(game.getGameStatus() == GameStatus.START){
            System.out.print("-> ");
            temp2 = scanner.nextLine();
            game.inputAnswer(temp2);
            history.addAction(temp2);
        }
        System.out.println(game.getGameStatus());
        System.out.println("Желаете отобразить историю? y - да");
        if ("y".equals(scanner.nextLine())){
            history.showHistory();
        }
    }
}