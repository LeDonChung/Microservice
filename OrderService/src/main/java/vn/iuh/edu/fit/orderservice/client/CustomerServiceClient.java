package vn.iuh.edu.fit.orderservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.iuh.edu.fit.orderservice.entity.Customer;

@FeignClient(name = "customer-mc-service", path = "/api/v1/customer")
public interface CustomerServiceClient {
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id);

}
