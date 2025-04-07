package vn.iuh.edu.fit.productservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.iuh.edu.fit.productservice.entity.Product;
import vn.iuh.edu.fit.productservice.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.saveProduct(product));
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(201).body(productService.saveProduct(product));
    }

    @PutMapping("/{id}/decrement/")
    public ResponseEntity<Product> decrementProduct(@PathVariable Long id, @RequestParam int quantity) {
        return ResponseEntity.status(201).body(productService.decrement(id, quantity));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
