package ss15_exception_debug;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập 3 cạnh của tam giác");
                System.out.print("Nhập cạnh x: ");
                double x = sc.nextDouble();
                System.out.print("Nhập cạnh y: ");
                double y = sc.nextDouble();
                System.out.print("Nhập cạnh z: ");
                double z = sc.nextDouble();

                if (x <= 0 || y <= 0 || z <= 0) {
                    throw new IllegalTriangleException("Cạnh phải lớn hơn 0");
                }
                if (x + y <= z || x + z <= y || y + z <= x) {
                    throw new IllegalTriangleException("Đây không phải là cạnh của tam giác");
                }
                System.out.println("Đây là tam giác hợp lệ");
                return;
            } catch (IllegalTriangleException e) {
                System.out.println("Lỗi : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn đã nhập sai kiểu dữ liệu");
                sc.nextLine();
            }
        }
    }
}
