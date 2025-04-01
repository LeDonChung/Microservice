package vn.iuh.edu.fit.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.iuh.edu.fit.productservice.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
