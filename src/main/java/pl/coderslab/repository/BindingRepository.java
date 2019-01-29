package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Binding;

public interface BindingRepository extends JpaRepository<Binding, Long> {
}
