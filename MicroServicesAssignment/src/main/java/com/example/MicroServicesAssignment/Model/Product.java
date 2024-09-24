package com.example.MicroServicesAssignment.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@NamedQuery(name = "Product.findExpensive", query = "SELECT p FROM Product p WHERE p.price > :price")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Double price;

}
