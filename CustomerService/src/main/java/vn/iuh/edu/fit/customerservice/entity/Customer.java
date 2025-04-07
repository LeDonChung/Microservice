package vn.iuh.edu.fit.customerservice.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String address;

    private String phoneNumber;

    private Integer status;
}
