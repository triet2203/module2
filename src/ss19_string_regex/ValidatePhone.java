package ss19_string_regex;

import java.util.Scanner;

public class ValidatePhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        System.out.print("Nhập số điện thoại: ");
        String phone = sc.nextLine();

        while (!phone.matches(regex)) {
            System.out.println("Số điện thoại không hợp lệ");
            System.out.print("Nhập lại số điện thoại: ");
            phone = sc.nextLine();
        }
        System.out.println("Số điện thoại hợp lệ");
    }
}
