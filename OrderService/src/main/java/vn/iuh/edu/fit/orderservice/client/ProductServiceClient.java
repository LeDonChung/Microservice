package vn.iuh.edu.fit.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.iuh.edu.fit.orderservice.entity.Product;

@FeignClient(name = "product-mc-service", path = "/api/v1/product")
public interface ProductServiceClient {
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id);
    @PutMapping("/{id}/decrement/")
    public ResponseEntity<Product> decrementProduct(@PathVariable Long id, @RequestParam int quantity);

}
