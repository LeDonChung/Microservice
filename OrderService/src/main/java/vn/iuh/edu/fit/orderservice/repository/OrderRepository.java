package vn.iuh.edu.fit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iuh.edu.fit.orderservice.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
