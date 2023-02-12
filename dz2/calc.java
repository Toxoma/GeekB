package Java.dz2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class calc {
    static float current = 0;
    static Scanner scaner = new Scanner(System.in);
    static Logger logger = Logger.getLogger(calc.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        String input = "";
        scaner = new Scanner(System.in);

        FileHandler fh = new FileHandler("calcLogs.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        do {
            System.out.printf("Текущее значение =\t%.2f\n", current);
            choose();
            input = scaner.next();
            if (input.equals("0"))
                break;

            switch (input) {
                case "1":
                    plus();
                    break;
                case "2":
                    minus();
                    break;
                case "3":
                    multy();
                    break;
                case "4":
                    division();
                    break;
                case "5":
                    clear();
                    break;
                default:
                    System.out.println("Вы ввели не то число... попробуйте снова!");
                    break;
            }
            System.out.println("___________________________________");
        } while (true);

        scaner.close();
        System.out.println("!!!Вход!!!");
    }

    public static float getFloat() throws Exception {
        return scaner.nextFloat();
    }

    public static void division() {
        System.out.printf("%.2f / ", current);
        try {
            float input = getFloat();
            if (input == 0) {
                System.out.println("Делить но 0 неьлзя!!! Повторите попытку...");
                division();
                return;
            }
            logger.info(String.format("%.2f / %f = %.2f", current, input, current/input));
            current /= input;
        } catch (Exception e) {
            System.out.println("Вы пытались ввести некорректное число! Повторите попытку...");
            scaner.next();
            division();
        }
    }

    public static void multy() {
        System.out.printf("%.2f * ", current);
        try {
            float input = getFloat();
            logger.info(String.format("%.2f * %f = %.2f", current, input, current*input));
            current *= input;
        } catch (Exception e) {
            System.out.println("Вы пытались ввести некорректное число! Повторите попытку...");
            scaner.next();
            multy();
        }
    }

    public static void minus() {
        System.out.printf("%.2f - ", current);
        try {
            float input = getFloat();
            logger.info(String.format("%.2f - %f = %.2f", current, input, current-input));
            current -= input;
        } catch (Exception e) {
            System.out.println("Вы пытались ввести некорректное число! Повторите попытку...");
            scaner.next();
            minus();
        }
    }

    public static void plus() {
        System.out.printf("%.2f + ", current);
        try {
            float input = getFloat();
            logger.info(String.format("%.2f + %f = %.2f", current, input, current+input));
            current += input;
        } catch (Exception e) {
            System.out.println("Вы пытались ввести некорректное число! Повторите попытку...");
            scaner.next();
            plus();
        }
    }

    public static void choose() {
        System.out.println("Для сложения нажмите\t1");
        System.out.println("Для вычитания нажмите\t2");
        System.out.println("Для умножения нажмите\t3");
        System.out.println("Для деления нажмите\t4");
        System.out.println("Для сброса нажмите\t5");
        System.out.println("Для выхода нажмите\t0");
        System.out.print("Ваш выбор: ");
    }

    public static void clear() {
        current = 0;
        logger.info(String.format("Сброс... Текущее = %.2f", current));
    }
}
