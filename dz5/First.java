import java.util.concurrent.ThreadLocalRandom;

// Реализовать задание и печать карты для волнового алгоритма

public class First {
    static String wall = "\u2593\u2593\u2593";
    static String cell = "   ";
    static String start = " @ ";
    static String stop = " x ";
    static String point = " o ";

    /*
     * 0 - клетка
     * 1 - стена
     * 2 - старт
     * 3 - стоп
     */
    static String[][] maze = new String[][] {
            { wall, wall, wall, wall, wall, wall, wall, wall, wall, wall, wall },
            { wall, start, cell, cell, cell, cell, cell, cell, wall, cell, wall },
            { wall, wall, wall, wall, wall, wall, wall, cell, wall, cell, wall },
            { wall, cell, cell, cell, cell, cell, wall, cell, wall, cell, wall },
            { wall, cell, wall, wall, wall, cell, wall, cell, wall, cell, wall },
            { wall, cell, wall, cell, cell, cell, wall, cell, cell, cell, wall },
            { wall, cell, wall, cell, wall, wall, wall, wall, wall, cell, wall },
            { wall, cell, wall, cell, cell, cell, cell, cell, wall, cell, wall },
            { wall, cell, wall, wall, wall, wall, wall, cell, wall, cell, wall },
            { wall, cell, cell, cell, cell, stop, wall, cell, cell, cell, wall },
            { wall, wall, wall, wall, wall, wall, wall, wall, wall, wall, wall },
    };

    public static void main(String[] args) {
        First.vivod(maze);
    }

    public static void vivod(String[][] mas) {
        System.out.println("________________");
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.printf("%s", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println("________________");
    }
}