package ss3_method;

import java.util.Scanner;

public class SumOfDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước của ma trận vuông: ");
        int row = sc.nextInt();
        int col = row;
        double[][] arr = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử [" + i + ", " + j + "]: ");
                arr[i][j] = sc.nextDouble();
            }
        }
        double result = sumDiagonal(arr);
        System.out.println("Tổng đường chéo chính: " + result);
    }

    public static double sumDiagonal(double[][] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
}
