package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
