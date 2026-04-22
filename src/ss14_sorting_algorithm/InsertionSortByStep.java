package ss14_sorting_algorithm;

import java.util.Arrays;

public class InsertionSortByStep {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        System.out.println("Mảng ban đầu: " + Arrays.toString(arr));

        int key, j;
        for (int i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            System.out.println("Lần " + i + ": chèn phần tử " + key);
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;

                System.out.println("Dịch chuyển: " + Arrays.toString(arr));
            }
            arr[j + 1] = key;
            System.out.println("Sau khi chèn: " + Arrays.toString(arr));
        }
        System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {11, 5, 2, 22, 13, 9};
        insertionSort(arr);
    }
}

