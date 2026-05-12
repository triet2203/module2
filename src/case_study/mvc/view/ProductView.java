package case_study.mvc.view;

import case_study.mvc.controller.ProductController;
import case_study.mvc.entity.Product;
import case_study.mvc.ultils.validate.ValidateInput;

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
            System.out.println("5. Tìm sản phẩm theo ID");
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
                case 5:
                    findProduct();
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
        int id = ValidateInput.inputPositiveInt("Nhập ID: ");
        String name = ValidateInput.inputString("Nhập tên sản phẩm: ");
        double price = ValidateInput.inputPositiveDouble("Nhập giá sản phẩm: ");
        int quantity = ValidateInput.inputPositiveInt("Nhập số lượng: ");
        String category = ValidateInput.inputString("Nhập danh mục: ");

        Product product = new Product(id, name, price, quantity, category, LocalDate.now());

        if (productController.add(product)) {
            System.out.println("Thêm sản phẩm thành công");
        } else {
            System.out.println("Thêm sản phẩm thất bại");
        }
    }

    private static void updateProduct() {
        int id = ValidateInput.inputPositiveInt("Nhập ID sản phẩm cần update: ");

        Product product = productController.findById(id);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }

        String name = ValidateInput.inputString("Nhập tên mới: ");
        double price = ValidateInput.inputPositiveDouble("Nhập giá mới: ");
        int quantity = ValidateInput.inputNonNegativeInt("Nhập số lượng mới: ");
        String category = ValidateInput.inputString("Nhập danh mục mới: ");

        Product newProduct = new Product(id, name, price, quantity, category, product.getCreatedDate());

        if (productController.update(newProduct)) {
            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }

    private static void deleteProduct() {
        int id = ValidateInput.inputPositiveInt("Nhập ID sản phẩm cần xóa: ");

        Product product = productController.findById(id);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }

        System.out.println("Sản phẩm cần xóa:");
        System.out.println(product);
        System.out.println("Bạn có chắc muốn xóa sản phẩm này không? (Y/N)");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy xóa sản phẩm");
            return;
        }

        if (productController.delete(id)) {
            System.out.println("Xóa sản phẩm thành công");
        } else {
            System.out.println("Không tìm thấy sản phẩm");
        }
    }

    private static void findProduct() {
        int id = ValidateInput.inputPositiveInt("Nhập ID cần tìm: ");

        if (productController.findById(id) == null) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println(productController.findById(id));
        }
    }
}
