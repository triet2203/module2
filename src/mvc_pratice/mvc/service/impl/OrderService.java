package mvc_pratice.mvc.service.impl;

import mvc_pratice.mvc.entity.Order;
import mvc_pratice.mvc.entity.OrderDetail;
import mvc_pratice.mvc.entity.Product;
import mvc_pratice.mvc.repository.OrderRepository;
import mvc_pratice.mvc.service.IService;

import java.util.List;

public class OrderService implements IService<Order> {
    private OrderRepository orderRepository = new OrderRepository();

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

    public void addProductToOrder(Order order, Product product, int quantity) {
        OrderDetail detail = new OrderDetail(product, quantity, product.getPrice());
        order.getDetails().add(detail);
    }

    public double calculateTotal(Order order) {
        double total = 0;
        for (OrderDetail detail : order.getDetails()) {
            total += detail.getPrice() * detail.getQuantity();
        }
        return total;
    }

    public void checkout(Order order) {
        order.setStatus("PAID");
    }
}
