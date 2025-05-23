package vn.iuh.edu.fit.productservice.service;

import vn.iuh.edu.fit.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProduct(Long id);

    Product decrement(Long id, int quantity);
}
