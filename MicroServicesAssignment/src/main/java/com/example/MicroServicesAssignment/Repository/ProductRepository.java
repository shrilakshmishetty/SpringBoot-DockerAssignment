package com.example.MicroServicesAssignment.Repository;

import com.example.MicroServicesAssignment.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("Select p from Product p where p.name=:name")
    Product findByName(String name);

    // This will automatically map to the named query "Product.findAllExpensive"
    List<Product> findExpensive(Double price);
}
