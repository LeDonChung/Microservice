package vn.iuh.edu.fit.productservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;

    private Integer quantity;

    private Integer status;
}
