// 2.Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package Java.dz2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.*;

public class second {
    public static void main(String[] args) throws SecurityException, IOException, NoSuchFieldException {
        int[] mas = {5, 3, 5, 3, 4, 4, 3, 2, 5, 4, 1, 2, 10, 777, 3};

        Logger logger = Logger.getLogger(second.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        logger.info("Изначальный массив: " + Arrays.toString(mas));

        for (int i = 0; i < mas.length-1; i++) {
            for (int j = i+1; j < mas.length; j++) {
                if (mas[i] < mas[j]) {
                    int temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                }
            }
            
            logger.info(i+1 + " итерация: " + Arrays.toString(mas));
        }
    }
}
