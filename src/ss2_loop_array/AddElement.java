package ss2_loop_array;

import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 3;
        arr[2] = 4;
        arr[3] = 2;
        arr[4] = 7;
        arr[5] = 0;
        arr[6] = 9;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập phần tử để thêm vào mảng: ");
        int x = sc.nextInt();
        System.out.print("Nhập vị trí mà phần tử thêm vào mảng: ");
        int index = sc.nextInt();
        int n = 7;

        if (index <= -1 || index >= n) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            for (int i = n; i > index; i--) {
                arr[i] = arr[i - 1];
            }

            arr[index] = x;
            n++;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
