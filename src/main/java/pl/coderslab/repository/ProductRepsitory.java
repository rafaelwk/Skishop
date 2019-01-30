package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Product;

public interface ProductRepsitory extends JpaRepository<Product, Long> {
}
