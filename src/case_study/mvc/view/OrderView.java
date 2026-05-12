package case_study.mvc.view;

import case_study.mvc.controller.CustomerController;
import case_study.mvc.controller.OrderController;
import case_study.mvc.controller.ProductController;
import case_study.mvc.entity.Customer;
import case_study.mvc.entity.Order;
import case_study.mvc.entity.OrderDetail;
import case_study.mvc.entity.Product;
import case_study.mvc.ultils.validate.ValidateInput;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private static OrderController orderController = new OrderController();
    private static ProductController productController = new ProductController();
    private static CustomerController customerController = new CustomerController();
    private static Scanner scanner = new Scanner(System.in);

    private static Order currentOrder;

    public static void orderMenu() {
        int choice;

        do {
            System.out.println("======= QUẢN LÝ ĐƠN HÀNG =======");
            System.out.println("1. Hiển thị danh sách đơn hàng");
            System.out.println("2. Tạo đơn hàng mới");
            System.out.println("3. Thêm sản phẩm vào đơn hàng");
            System.out.println("4. Xem tổng tiền tạm tính");
            System.out.println("5. Thanh toán đơn hàng");
            System.out.println("6. Hiển thị chi tiết đơn hàng");
            System.out.println("7. Xóa đơn hàng");
            System.out.println("0. Quay lại");
            System.out.print("Nhập lựa chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showOrder();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    addProductToCurrentOrder();
                    break;
                case 4:
                    showCurrentOrder();
                    break;
                case 5:
                    checkoutCurrentOrder();
                    break;
                case 6:
                    showOrderDetail();
                    break;
                case 7:
                    deleteOrder();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        } while (choice != 0);
    }

    private static void showOrder() {
        List<Order> orders = orderController.findAll();

        if (orders.isEmpty()) {
            System.out.println("Hiện tại chưa có đơn hàng");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

    private static void showOrderDetail() {
        List<OrderDetail> details = orderController.findAllOrderDetails();

        if (details.isEmpty()) {
            System.out.println("Hiện tại chưa có chi tiết đơn hàng");
            return;
        }

        System.out.println("======= DANH SÁCH CHI TIẾT ĐƠN HÀNG =======");
        for (OrderDetail detail : details) {
            System.out.println(detail);
        }
    }

    private static void createOrder() {
        int orderId = ValidateInput.inputPositiveInt("Nhập ID đơn hàng");
        int customerId = ValidateInput.inputPositiveInt("Nhập ID khách hàng: ");

        Customer customer = customerController.findById(customerId);

        if (customer == null) {
            System.out.println("Không tìm thấy khách hàng");
            return;
        }

        currentOrder = new Order(orderId, customerId, LocalDate.now(), "PENDING");

        if (orderController.add(currentOrder)) {
            System.out.println("Tạo đơn hàng thành công");
            System.out.println("Khách hàng: " + customer);
        } else {
            System.out.println("Tạo đơn hàng thất bại");
            currentOrder = null;
        }


    }

    private static void addProductToCurrentOrder() {
        if (currentOrder == null) {
            System.out.println("Bạn cần tạo đơn hàng trước");
            return;
        }

        int productId = ValidateInput.inputPositiveInt("Nhập ID sản phẩm: ");

        Product product = productController.findById(productId);

        if (product == null) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }

        System.out.println("Sản phẩm tìm thấy: " + product);
        int quantity = ValidateInput.inputPositiveInt("Nhập số lượng muốn mua: ");

        if (quantity <= 0) {
            System.out.println("Số lượng phải lớn hơn 0");
            return;
        }

        if (product.getQuantity() < quantity) {
            System.out.println("Sản phẩm không đủ số lượng trong kho");
            System.out.println("Số lượng còn lại: " + product.getQuantity());
            return;
        }


        if (orderController.addProductToOrder(currentOrder, product, quantity)) {
            System.out.println("Thêm sản phẩm vào đơn hàng thành công");
        } else {
            System.out.println("Thêm sản phẩm vào đơn hàng thất bại");
        }

    }

    private static void showCurrentOrder() {
        if (currentOrder == null) {
            System.out.println("Chưa có đơn hàng hiện tại");
            return;
        }

        System.out.println("======= ĐƠN HÀNG HIỆN TẠI =======");
        System.out.println(currentOrder);

        if (currentOrder.getDetails() == null || currentOrder.getDetails().isEmpty()) {
            System.out.println("Đơn hàng chưa có sản phẩm nào");
            return;
        }

        System.out.println("------- Chi tiết đơn hàng -------");
        for (OrderDetail detail : currentOrder.getDetails()) {
            System.out.println(detail);
        }

        System.out.println("Tổng tiền: " + orderController.calculateTotal(currentOrder));
    }

    private static void checkoutCurrentOrder() {
        if (currentOrder == null) {
            System.out.println("Chưa có đơn hàng để thanh toán");
            return;
        }

        if (currentOrder.getDetails() == null || currentOrder.getDetails().isEmpty()) {
            System.out.println("Đơn hàng chưa có sản phẩm, không thể thanh toán");
            return;
        }

        showCurrentOrder();

        System.out.print("Bạn có chắc muốn thanh toán đơn hàng này không? Y/N: ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy thanh toán");
            return;
        }

        if (orderController.checkout(currentOrder)) {
            System.out.println("Thanh toán thành công");
            currentOrder = null;
        } else {
            System.out.println("Thanh toán thất bại");
        }
    }

    private static void deleteOrder() {
        int id = ValidateInput.inputPositiveInt("Nhập ID đơn hàng cần xóa: ");

        Order order = orderController.findById(id);
        if (order == null) {
            System.out.println("Không tìm thấy đơn hàng");
            return;
        }

        System.out.println("Đơn hàng cần xóa:");
        System.out.println(order);

        System.out.println("Bạn có chắc muốn xóa đơn hàng này không? Y/N: ");
        String confirm = scanner.nextLine();
        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Đã hủy xóa đơn hàng");
            return;
        }

        if (orderController.delete(id)) {
            System.out.println("Xóa đơn hàng thành công");
        } else {
            System.out.println("Không tìm thấy đơn hàng");
        }
    }
}


