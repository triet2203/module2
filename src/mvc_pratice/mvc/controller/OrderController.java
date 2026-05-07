package mvc_pratice.mvc.controller;

import mvc_pratice.mvc.entity.Order;
import mvc_pratice.mvc.entity.Product;
import mvc_pratice.mvc.service.impl.OrderService;

import java.util.List;

public class OrderController {
    private OrderService orderService = OrderService.getInstance();

    public boolean add(Order order) {
        return orderService.add(order);
    }

    public boolean update(Order order) {
        return orderService.update(order);
    }

    public boolean delete(int id) {
        return orderService.delete(id);
    }

    public List<Order> findAll() {
        return orderService.findAll();
    }

    public void addProductToOrder(Order order, Product product, int quantity) {
        orderService.addProductToOrder(order, product, quantity);
    }

    public double calculateTotal(Order order) {
        return orderService.calculateTotal(order);
    }

    public void checkout(Order order) {
        orderService.checkout(order);
    }
}
