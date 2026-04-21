package ss13_searching_algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Mảng sau khi đã sắp xếp: " + Arrays.toString(arr));
        System.out.print("Nhập giá trị cần tìm: ");
        int value = sc.nextInt();

        int result = binarySearch(arr, 0, arr.length - 1, value);

        if (result != -1) {
            System.out.println("Tìm thấy tại vị trí: " + result);
        } else {
            System.out.println("Không tìm thấy");
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;

        if (array[middle] == value) {
            return middle;
        }

        if (value > array[middle]) {
            return binarySearch(array, middle + 1, right, value);
        }
        return binarySearch(array, left, middle - 1, value);
    }
}

