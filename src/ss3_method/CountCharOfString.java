package ss3_method;

import java.util.Scanner;

public class CountCharOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập một chuỗi ký tự bất kì: ");
        String str = sc.nextLine();
        System.out.print("Nhập ký tự cần đếm: ");
        char c = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có ký tự này trong chuỗi");
        }
        System.out.println("Tổng ký tự " + c + " trong chuỗi " + str + ": " + count);
    }
}
