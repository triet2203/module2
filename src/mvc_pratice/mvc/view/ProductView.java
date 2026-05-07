package mvc_pratice.mvc.view;

import mvc_pratice.mvc.controller.ProductController;
import mvc_pratice.mvc.entity.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static ProductController productController = new ProductController();
    private static Scanner scanner = new Scanner(System.in);

    public static void productMenu() {
        int choice;

        do {
            System.out.println("======= QUẢN LÝ SẢN PHẨM =======");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        } while (choice != 0);
    }

    private static void showProduct() {
        List<Product> products = productController.findAll();

        if (products.isEmpty()) {
            System.out.println("Hiện tại chưa có sản phẩm nào");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addProduct() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập danh mục: ");
        String category = scanner.nextLine();

        Product product = new Product(id, name, price, quantity, category, LocalDate.now());

        if (productController.add(product)) {
            System.out.println("Thêm sản phẩm thành công");
        } else {
            System.out.println("Thêm sản phẩm thất bại");
        }
    }

    private static void updateProduct() {
        System.out.print("Nhập ID sản phẩm cẩn update: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productController.findById(id);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }

        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá mới: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập số lượng mới: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập danh mục mới: ");
        String category = scanner.nextLine();

        Product newProduct = new Product(id, name, price, quantity, category, product.getCreatedDate());

        if (productController.update(newProduct)) {
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }

    private static void deleteProduct() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (productController.delete(id)) {
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }
}
