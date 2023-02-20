package Java.dz3;

import java.sql.Array;
import java.util.Arrays;

public class First {

    public static void main(String[] args) {
        int[] actual = { 10, 6, 8, 5, 7, 3, 4 };
        int[] expected = { 3, 4, 5, 6, 7, 8, 10 };
        First.mergeSort(actual, actual.length);
        
        vivod(actual);
        System.out.println(Arrays.equals(actual, expected));
    }

    public static void mergeSort(int[] mas, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] lmas = new int[mid];
        int[] rmas = new int[length - mid];

        for (int i = 0; i < mid; i++) {
            lmas[i] = mas[i];
        }
        for (int i = mid; i < length; i++) {
            rmas[i - mid] = mas[i];
        }
        mergeSort(lmas, mid);
        mergeSort(rmas, length - mid);

        merge(mas, lmas, rmas, mid, length - mid);
    }

    public static void merge(
            int[] mas, int[] lmas, int[] rmas, int leftPoint, int rightPoint) {

        int i = 0, j = 0, k = 0;
        while (i < leftPoint && j < rightPoint) {
            if (lmas[i] <= rmas[j]) {
                mas[k++] = lmas[i++];
            } else {
                mas[k++] = rmas[j++];
            }
        }
        while (i < leftPoint) {
            mas[k++] = lmas[i++];
        }
        while (j < rightPoint) {
            mas[k++] = rmas[j++];
        }
    }

    public static void vivod(int[] a){
        System.out.print("[ ");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length-1) {
                System.out.print(a[i]);
            }else{
                System.out.print(a[i]+", ");
            }
        }
        System.out.print(" ]\n");
    }
}
