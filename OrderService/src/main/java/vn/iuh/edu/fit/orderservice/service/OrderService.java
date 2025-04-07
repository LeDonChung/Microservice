package vn.iuh.edu.fit.orderservice.service;

import vn.iuh.edu.fit.orderservice.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order) throws Exception;

    void deleteOrder(Long orderId);

    Order getOrderById(Long orderId);

    List<Order> getAllOrders();
}
