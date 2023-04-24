import java.util.concurrent.ThreadLocalRandom;

// Реализовать задание и печать карты для волнового алгоритма

public class First {
    static String wall = "\u2593\u2593\u2593";
    static String cell = "   ";
    static String start = " @ ";
    static String stop = " x ";
    static String point = " ° ";

    static int curX = 1;
    static int curY = 1;

    static boolean continueFlag = true;

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
        First.findWay(maze);
        First.vivod(maze);
    }

    public static void makeStep() {
        First.vivod(maze);
        int tempX = curX;
        int tempY = curY;

        for (int i = 0; i < 4; i++) {
            if (First.isEnd())
                break;
            switch (i) {
                case 0:
                    First.goTop();
                    curX = tempX;
                    curY = tempY;
                    break;
                case 1:
                    First.goLeft();
                    curX = tempX;
                    curY = tempY;
                    break;
                case 2:
                    First.goDown();
                    curX = tempX;
                    curY = tempY;
                    break;
                case 3:
                    First.goRight();
                    curX = tempX;
                    curY = tempY;
                    break;
            }
        }

        if (First.isEnd())
            return;
        maze[curX][curY] = cell;
    }

    public static boolean isEnd() {
        if (!continueFlag || maze[curX][curY] == stop) {
            continueFlag = false;
            return true;
        }
        return false;
    }

    public static void goTop() {
        curX--;
        if (First.isEnd())
            return;
        if (curX > 0 && maze[curX][curY] == cell) {
            maze[curX][curY] = point;
            First.makeStep();
        } else
            curX++;
    }

    public static void goRight() {
        curY++;
        if (First.isEnd())
            return;
        if (curY < maze.length - 1 && maze[curX][curY] == cell) {
            maze[curX][curY] = point;
            First.makeStep();
        } else
            curY--;
    }

    public static void goDown() {
        curX++;
        if (First.isEnd())
            return;
        if (curX < maze[0].length - 1 && maze[curX][curY] == cell) {
            maze[curX][curY] = point;
            First.makeStep();
        } else
            curX--;
    }

    public static void goLeft() {
        curY--;
        if (First.isEnd())
            return;
        if (curY > 0 && maze[curX][curY] == cell) {
            maze[curX][curY] = point;
            First.makeStep();
        } else
            curY++;
    }

    public static void findWay(String[][] mas) {
        First.makeStep();
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