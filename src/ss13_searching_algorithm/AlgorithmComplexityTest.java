package ss13_searching_algorithm;

import java.util.Scanner;

public class AlgorithmComplexityTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Nhập chuỗi -> O(n)
        System.out.print("Enter a string: ");
        String inputString = sc.nextLine();

        //Khởi tạo mảng 255 phần tử -> O(1) (hằng số)
        int[] frequentChar = new int[255];

        //Duyệt chuỗi -> O(n)
        for (int i = 0; i < inputString.length(); i++) {
            int ascii = (int) inputString.charAt(i);
            frequentChar[ascii] += 1;
        }
        int max = 0;
        char character = (char) 255;

        //Duyệt mảng 255 phần tử -> O(1) (255 là hằng số)
        for (int j = 0; j < 255; j++) {
            if (frequentChar[j] > max) {
                max = frequentChar[j];
                character = (char) j;
            }
        }
        // In kết quả -> O(1)
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
// Tổng độ phức tạp:
// T(n) = O(n) + O(1) + O(n) + O(1) = O(n)
// Độ phức tạp thời gian: O(n)
// Độ phức tạp không gian: O(1)