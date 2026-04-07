package ss3_method;

import java.util.Scanner;

public class SumCol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int col = sc.nextInt();
        double[][] arr = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử [" + i + ", " + j + "]: ");
                arr[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Nhập cột mà bạn muốn tính tổng: ");
        int col1 = sc.nextInt();
        if (col1 < 0 || col1 >= col) {
            System.out.println("Cột không hợp lệ");
            return;
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][col1];
        }
        System.out.printf("Tổng của cột %d: %.1f", col1, sum);
    }
}
