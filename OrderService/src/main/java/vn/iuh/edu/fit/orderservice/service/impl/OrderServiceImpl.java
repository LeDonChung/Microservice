package vn.iuh.edu.fit.orderservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.orderservice.client.CustomerServiceClient;
import vn.iuh.edu.fit.orderservice.client.ProductServiceClient;
import vn.iuh.edu.fit.orderservice.entity.Customer;
import vn.iuh.edu.fit.orderservice.entity.Order;
import vn.iuh.edu.fit.orderservice.entity.Product;
import vn.iuh.edu.fit.orderservice.repository.OrderRepository;
import vn.iuh.edu.fit.orderservice.service.OrderService;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerServiceClient customerServiceClient;
    @Autowired
    private ProductServiceClient productServiceClient;

    @Override
    public Order createOrder(Order order) throws Exception {
        try {
            // Kiểm tra tồn tại của khách hàng
            Customer customer = customerServiceClient.getCustomerById(order.getCustomerId()).getBody();

            // Kiểm tra tồn tại của sản phẩm
            Order finalOrder = order;
            order.getOrderDetails().forEach(orderDetail -> {
                orderDetail.setOrder(finalOrder);
                Product product = productServiceClient.getProductById(orderDetail.getProductId()).getBody();
                // Kiểm tra tồn kho
                if(product.getQuantity() < orderDetail.getQuantity()) {
                    throw new RuntimeException("Sản phẩm không đủ số lượng trong kho");
                }
            });

            order.setStatus("PENDING");
            order.setOrderDate(LocalDate.now());

            order = orderRepository.save(order);

            // Cập nhật số lượng sản phẩm trong kho
            order.getOrderDetails().forEach(orderDetail -> {
                productServiceClient.decrementProduct(orderDetail.getProductId(), orderDetail.getQuantity());
            });

            return order;
        } catch (Exception e) {
            throw new Exception("Lỗi khi tạo đơn hàng: " + e.getMessage());
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        // Check if the order exists
        orderRepository.findById(orderId).ifPresent(order -> orderRepository.delete(order));
    }

    @Override
    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
