package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Ski;

public interface SkiRepository extends JpaRepository<Ski, Long> {
}
