package ss2_loop_array;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] arr = {2, 10, 7, 8, 5, 4, 6, 9};
        System.out.println(Arrays.toString(arr));
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần tử cần xóa: ");
        int x = sc.nextInt();
        int index = -1;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không có phần tử này trong mảng");
        } else {
            for (int i = index; i < n - 1; i++) {
                arr[i] = arr[i + 1];
            }
            n--;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
