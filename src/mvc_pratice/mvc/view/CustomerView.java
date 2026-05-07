package mvc_pratice.mvc.view;

import mvc_pratice.mvc.controller.CustomerController;
import mvc_pratice.mvc.entity.Customer;

import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static CustomerController customerController = new CustomerController();
    private static Scanner scanner = new Scanner(System.in);

    public static void customerMenu() {
        int choice;

        do {
            System.out.println("======= QUẢN LÝ KHÁCH HÀNG ======");
            System.out.println("1. Hiển thị danh sách khách hàng");
            System.out.println("2. Thêm mới khách hàng");
            System.out.println("3. Sửa thông tin khách hàng");
            System.out.println("4. Xóa khách hàng");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showCustomer();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        } while (choice != 0);
    }

    public static void showCustomer() {
        List<Customer> customers = customerController.findAll();

        if (customers.isEmpty()) {
            System.out.println("Danh sách khách hàng rỗng");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public static void addCustomer() {
        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại: ");
        String phone = scanner.nextLine();

        Customer customer = new Customer(id, name, phone);

        if (customerController.add(customer)) {
            System.out.println("Thêm mới khách hàng thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void updateCustomer() {
        System.out.print("Nhập ID khách hàng cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());

        Customer customer = customerController.findById(id);

        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        System.out.print("Nhập tên khách hàng mới: ");
        String name = scanner.nextLine();
        System.out.print("Nhập số điện thoại mới: ");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id, name, phone);

        if (customerController.update(newCustomer)) {
            System.out.println("Cập nhật thông tin khách hàng thành công");
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }

    public static void deleteCustomer() {
        System.out.print("Nhập ID khách hàng cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (customerController.delete(id)) {
            System.out.println("Xóa khách hàng thành công");
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }

    }
}
