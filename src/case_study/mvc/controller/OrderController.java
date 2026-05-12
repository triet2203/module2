package case_study.mvc.controller;

import case_study.mvc.entity.Order;
import case_study.mvc.entity.OrderDetail;
import case_study.mvc.entity.Product;
import case_study.mvc.service.impl.OrderService;

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

    public Order findById(int id) {
        return orderService.findById(id);
    }

    public boolean addProductToOrder(Order order, Product product, int quantity) {
        return orderService.addProductToOrder(order, product, quantity);
    }

    public double calculateTotal(Order order) {
        return orderService.calculateTotal(order);
    }

    public boolean checkout(Order order) {
        return orderService.checkout(order);
    }

    public List<OrderDetail> findAllOrderDetails() {
        return orderService.findAllOrderDetails();
    }
}
