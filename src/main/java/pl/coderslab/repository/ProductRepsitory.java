package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Product;
import pl.coderslab.entity.ProductType;

import java.util.List;

public interface ProductRepsitory extends JpaRepository<Product, Long> {

    List<Product> findAllByProductType(ProductType productType);

}
