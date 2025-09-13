package com.gabr.e_commerce.repository;
import com.gabr.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
