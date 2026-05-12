package case_study.mvc.service.impl;

import case_study.mvc.entity.Order;
import case_study.mvc.entity.OrderDetail;
import case_study.mvc.entity.Product;
import case_study.mvc.repository.OrderDetailRepository;
import case_study.mvc.repository.OrderRepository;
import case_study.mvc.repository.ProductRepository;
import case_study.mvc.service.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    private OrderRepository orderRepository = new OrderRepository();
    private ProductRepository productRepository = new ProductRepository();
    private OrderDetailRepository orderDetailRepository = new OrderDetailRepository();

    private OrderService() {
    }

    private static OrderService instance;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    @Override
    public boolean add(Order order) {
        return orderRepository.add(order);
    }

    @Override
    public boolean update(Order order) {
        return orderRepository.update(order);
    }

    @Override
    public boolean delete(int id) {
        return orderRepository.delete(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public boolean addProductToOrder(Order order, Product product, int quantity) {
        if (order == null || product == null || quantity <= 0) {
            return false;
        }

        if (product.getQuantity() < quantity) {
            return false;
        }

        String orderId = String.valueOf(order.getId());
        OrderDetail detail = new OrderDetail(orderId ,product, quantity, product.getPrice());
        order.getDetails().add(detail);
        return orderDetailRepository.add(detail);
    }

    @Override
    public double calculateTotal(Order order) {
        if (order == null) {
            return 0;
        }

        String orderId = String.valueOf(order.getId());
        List<OrderDetail> details = orderDetailRepository.findByOrderId(orderId);
        double total = 0;

        for (OrderDetail detail : details) {
            total += detail.getTotalPrice();
        }
        return total;
    }

    @Override
    public boolean checkout(Order order) {
        if (order == null) {
            return false;
        }

        String orderId = String.valueOf(order.getId());

        List<OrderDetail> details = orderDetailRepository.findByOrderId(orderId);

        if (details == null || details.isEmpty()) {
            return false;
        }

        int productId;
        for (OrderDetail detail : details) {
            productId = detail.getProduct().getId();
            Product product = productRepository.findById(productId);

            if (product == null) {
                return false;
            }

            if (product.getQuantity() < detail.getQuantity()) {
                return false;
            }
        }

        for (OrderDetail detail : details) {
            productId = detail.getProduct().getId();
            Product product = productRepository.findById(productId);

            if (product == null) {
                return false;
            }

            product.setQuantity(product.getQuantity() - detail.getQuantity());
            productRepository.update(product);
        }
        order.setStatus("PAID");
        return orderRepository.update(order);
    }

    @Override
    public List<OrderDetail> findAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id);
    }
}
