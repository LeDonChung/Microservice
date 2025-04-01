package vn.iuh.edu.fit.productservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iuh.edu.fit.productservice.entity.Product;
import vn.iuh.edu.fit.productservice.repository.ProductRepository;
import vn.iuh.edu.fit.productservice.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveProduct(Product productSave) {
        Product product = new Product();
        System.out.println("Save: "+ productSave);
        if (productSave.getId() == null) {
            product = productSave;
        } else {
            product = productRepository.findById(productSave.getId()).orElse(null);
            if(product == null) {
                return null;
            }
            if (productSave.getName() != null) {
                product.setName(productSave.getName());
            }
            if (productSave.getDescription() != null) {
                product.setDescription(productSave.getDescription());
            }
            if (productSave.getPrice() != null) {
                product.setPrice(productSave.getPrice());
            }
            if (productSave.getQuantity() != null) {
                product.setQuantity(productSave.getQuantity());
            }
            if (productSave.getStatus() != null) {
                product.setStatus(productSave.getStatus());
            }
        }
        System.out.println(product);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
