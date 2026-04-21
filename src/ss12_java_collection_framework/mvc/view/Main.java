package ss12_java_collection_framework.mvc.view;

import ss12_java_collection_framework.mvc.entity.Product;
import ss12_java_collection_framework.mvc.controller.ProductController;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductController controller = new ProductController();
        System.out.println("Chào mừng đến với hệ thống sản phẩm");
        while (true) {
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Sửa sản phẩm theo id");
            System.out.println("4. Xóa sản phẩm theo id");
            System.out.println("5. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("6. Sắp xếp sản phẩm tăng dần theo giá");
            System.out.println("7. Sắp xếp sản phẩm giảm dần theo giá");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    List<Product> list = controller.findAll();
                    for (Product p : list) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    addProduct(sc, controller);
                case 3:
                    editProduct(sc, controller);
                    break;
                case 4:
                    deleteProduct(sc, controller);
                    break;
                case 5:
                    searchProduct(sc, controller);
                    break;
                case 6:
                    List<Product> ascList = controller.sortAsc();
                    for (Product p : ascList) {
                        System.out.println(p);
                    }
                    break;
                case 7:
                    List<Product> descList = controller.sortDesc();
                    for (Product p : descList) {
                        System.out.println(p);
                    }
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }

    private static void searchProduct(Scanner sc, ProductController controller) {
        System.out.print("Nhập tên cần tìm: ");
        String keyword = sc.nextLine();

        List<Product> result = controller.search(keyword);
        if (result.isEmpty()) {
            System.out.println("Không tìm thấy");
        } else {
            for (Product p : result) {
                System.out.println(p);
            }
        }
    }

    private static void deleteProduct(Scanner sc, ProductController controller) {
        System.out.print("Nhập id cần xóa: ");
        int deleteId = Integer.parseInt(sc.nextLine());

        if (controller.delete(deleteId)) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Không tìm thấy id");
        }
    }

    private static void editProduct(Scanner sc, ProductController controller) {
        System.out.print("Nhập id cần sửa: ");
        int editId = Integer.parseInt(sc.nextLine());
        System.out.print("Tên mới: ");
        String newNName = sc.nextLine();
        System.out.print("Giá mới: ");
        double newPrice = Double.parseDouble(sc.nextLine());

        if (controller.edit(editId, newNName, newPrice)) {
            System.out.println("Sửa thành công");
        } else {
            System.out.println("Không tìm thấy id");
        }
    }

    private static void addProduct(Scanner sc, ProductController controller) {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());

        if (controller.add(new Product(id, name, price))) {
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Thêm thất bại");
        }
    }
}
