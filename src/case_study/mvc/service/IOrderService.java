package case_study.mvc.service;

import case_study.mvc.entity.Order;
import case_study.mvc.entity.OrderDetail;
import case_study.mvc.entity.Product;

import java.util.List;

public interface IOrderService extends IService<Order>{
    boolean addProductToOrder(Order order, Product product, int quantity);

    double calculateTotal(Order order);

    boolean checkout(Order order);

    List<OrderDetail> findAllOrderDetails();

    Order findById(int id);
}
