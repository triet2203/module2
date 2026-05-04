package ss19_string_regex;

import java.util.Scanner;

public class ValidateClassName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String regex = "^[ACP]\\d{4}[GHIK]$";
        System.out.print("Nhập tên lớp học để kiểm tra: ");
        String validateClass = sc.nextLine();

        while (!validateClass.matches(regex)) {
            System.out.println("Tên không hợp lệ");
            System.out.print("Nhập lại tên: ");
            validateClass = sc.nextLine();
        }
        System.out.println("Tên hợp lệ");
    }
}
