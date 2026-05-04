package ss17_binary_file;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductManager productManager = new ProductManager();

        while (true) {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị danh sách sản phẩm");
            System.out.println("3. Tìm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Nhập hàng sản xuất: ");
                    String manufacturer = sc.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = sc.nextLine();
                    productManager.addProduct(new Product(id, name, price, manufacturer, description));
                    break;
                case 2:
                    productManager.display();
                    break;
                case 3:
                    System.out.println("Nhập tên cần tìm");
                    String key = sc.nextLine();
                    productManager.search(key);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }
}
