// +Написать программу вычисления n-ого треугольного числа.

package Java.dz1;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        int num = getInput();
        int result = num*(num+1)/2;
        System.out.printf("Итоговое число: %d", result);
    }

    public static int getInput() {
        Scanner input = new Scanner(System.in);
        int num = -1;
        try {
            do {
                System.out.print("Введите ваше число: ");
                num = input.nextInt();
                if (num < 1 ) {
                    System.out.print("Введите число > 0!!!\n");
                }
            } while (num < 1);
        } catch (Exception e) {
            System.out.print("Вы пытались ввести не число... попробуйте снова!\n");
            num = getInput();
        }
        
        input.close();
        return num;
    }
}
