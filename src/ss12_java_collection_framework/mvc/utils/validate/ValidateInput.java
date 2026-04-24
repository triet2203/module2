package ss12_java_collection_framework.mvc.utils.validate;

import java.util.Scanner;

public class ValidateInput {
    public static int checkChoice() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.print("Nhập lựa chọn: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không phù hợp, vui lòng nhập lại");
            } catch (Exception e) {
                System.out.println("Lỗi");
            }
        }

    }
}
