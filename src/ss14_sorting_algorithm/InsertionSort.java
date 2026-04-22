package ss14_sorting_algorithm;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 6, 9, 2, 4, 5};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] list) {
        int n = list.length;
        int key, j;
        for (int i = 1; i < n; i++) {
            key = list[i];
            j = i - 1;
            while (j >= 0 && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
}

