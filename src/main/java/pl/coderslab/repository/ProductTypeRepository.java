package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
