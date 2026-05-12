package case_study.mvc.ultils.validate;

import java.util.Scanner;

public class ValidateInput {
    private static final Scanner sc = new Scanner(System.in);

    public static int inputInt(String message) {
        int number;

        while (true) {
            System.out.print(message);

            try {
                number = Integer.parseInt(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số nguyên");
            }
        }
    }

    public static int inputPositiveInt(String message) {
        int number;

        while (true) {
            number = inputInt(message);

            if (number > 0) {
                return number;
            }

            System.out.println("Giá trị phải lớn hơn 0");
        }
    }

    public static int inputNonNegativeInt(String message) {
        int number;

        while (true) {
            number = inputInt(message);

            if (number >= 0) {
                return number;
            }

            System.out.println("giá trị không được âm");
        }
    }

    public static double inputDouble(String message) {
        double number;

        while (true) {
            System.out.print(message);

            try {
                number = Double.parseDouble(sc.nextLine());
                return number;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ, vui lòng nhập số thực");
            }
        }
    }

    public static double inputPositiveDouble(String message) {
        double number;

        while (true) {
            number = inputDouble(message);

            if (number > 0) {
                return number;
            }

            System.out.println("Giá trị phải lớn hơn 0");
        }
    }

    public static String inputString(String message) {
        String value;

        while (true) {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Không được để trống");
        }
    }

    public static String inputPhone(String message) {
        String phone;

        while (true) {
            System.out.print(message);
            phone = sc.nextLine().trim();

            if (phone.matches("^0\\d{9}$")) {
                return phone;
            }

            System.out.println("Số điện thoại không hợp lệ");
        }
    }
}
