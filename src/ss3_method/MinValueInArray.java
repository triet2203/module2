package ss3_method;

import java.util.Scanner;

public class MinValueInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài của mảng: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ: " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                 min = arr[i];
            }
        }
        System.out.println("Min: " + min);
    }
}
