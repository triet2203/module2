package case_study.mvc.view;

import case_study.mvc.controller.CustomerController;
import case_study.mvc.entity.Customer;
import case_study.mvc.ultils.validate.ValidateInput;

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
        int id = ValidateInput.inputPositiveInt("Nhập ID: ");
        String name = ValidateInput.inputString("Nhập tên khách hàng: ");
        String phone = ValidateInput.inputPhone("Nhập số điện thoại: ");

        Customer customer = new Customer(id, name, phone);

        if (customerController.add(customer)) {
            System.out.println("Thêm mới khách hàng thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }

    public static void updateCustomer() {
        int id = ValidateInput.inputPositiveInt("Nhập ID khách hàng cần sửa: ");

        Customer customer = customerController.findById(id);

        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        String name = ValidateInput.inputString("Nhập tên khách hàng mới: ");
        String phone = ValidateInput.inputPhone("Nhập số điện thoại mới: ");

        Customer newCustomer = new Customer(id, name, phone);

        if (customerController.update(newCustomer)) {
            System.out.println("Cập nhật thông tin khách hàng thành công");
        } else {
            System.out.println("Cập nhật thất bại");
        }
    }

    public static void deleteCustomer() {
        int id = ValidateInput.inputPositiveInt("Nhập ID khách hàng cần xóa: ");
        Customer customer = customerController.findById(id);

        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        System.out.println("Khách hàng cần xóa");
        System.out.println(customer);
        System.out.println("Bạn có chắc muốn xóa khách hàng này không? (Y/N)");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy xóa khách hàng");
            return;
        }

        if (customerController.delete(id)) {
            System.out.println("Xóa khách hàng thành công");
        } else {
            System.out.println("Không tìm thấy khách hàng");
        }
    }
}
