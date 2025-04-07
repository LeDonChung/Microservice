package vn.iuh.edu.fit.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iuh.edu.fit.orderservice.entity.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
