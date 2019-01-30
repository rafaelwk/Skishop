package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
