package vn.iuh.edu.fit.orderservice.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private Long id;

    private String fullName;

    private String address;

    private String phoneNumber;

    private Integer status;
}
