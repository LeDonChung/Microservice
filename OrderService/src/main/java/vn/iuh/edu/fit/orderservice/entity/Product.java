package vn.iuh.edu.fit.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private Integer status;
}
