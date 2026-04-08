package ss2_loop_array;

import java.util.Arrays;
import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7, 0, 9};
        int n = arr.length;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần tử để thêm vào mảng: ");
        int x = sc.nextInt();
        System.out.print("Nhập vị trí mà phần tử thêm vào mảng: ");
        int index = sc.nextInt();

        if (index < 0 || index > n) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            int[] newArr = Arrays.copyOf(arr, n + 1);
            for (int i = n; i > index; i--) {
                newArr[i] = newArr[i - 1];
            }
            newArr[index] = x;

            for (int i = 0; i < newArr.length; i++) {
                System.out.print(newArr[i] + " ");
            }
        }
    }
}
