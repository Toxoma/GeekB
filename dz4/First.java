package Java.dz4;

import java.util.Arrays;

public class First {

    public static void main(String[] args) {
        int[] actual = { 10, 6, 8, 5, 7, 3, 4 };
        int[] expected = { 3, 4, 5, 6, 7, 8, 10 };
        sort(actual);

        System.out.println("Sorted array is");
        vivod(actual);

        System.out.println(Arrays.equals(actual, expected));
    }

    public static void sort(int arr[])
    {
        int length = arr.length;

        for (int i = length / 2 - 1; i >= 0; i--)
            heap(arr, length, i);

        for (int i=length-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heap(arr, i, 0);
        }
    }

    public static void heap(int arr[], int length, int i)
    {
        int root = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < length && arr[l] > arr[root])
            root = l;

        if (r < length && arr[r] > arr[root])
            root = r;

        if (root != i)
        {
            int temp = arr[i];
            arr[i] = arr[root];
            arr[root] = temp;

            heap(arr, length, root);
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
