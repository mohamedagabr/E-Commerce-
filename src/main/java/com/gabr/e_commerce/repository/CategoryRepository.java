package com.gabr.e_commerce.repository;
import com.gabr.e_commerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
     Optional<Category> findByCategoryName(String name);

}
