package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Poles;

public interface PolesRepository extends JpaRepository<Poles, Long> {
}
