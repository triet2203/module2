package ss11_generic.excersice;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một số: ");
        int number = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }

        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop();
        }
        System.out.println("Binary = " + binary);
    }
}
