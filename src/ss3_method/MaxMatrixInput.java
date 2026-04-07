package ss3_method;

import java.util.Scanner;

public class MaxMatrixInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng: ");
        int row = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int col = sc.nextInt();

        double[][] matrix = new double[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Nhập phần tử [ " + i + ", " + j + "]: ");
                matrix[i][j] = sc.nextDouble();
            }
        }

        double max = matrix[0][0];
        row = 0;
        col = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Position: ( " + row + ", " + col + ")");
    }

}
