package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Boot;

public interface BootRepsitory extends JpaRepository<Boot, Long> {
}
