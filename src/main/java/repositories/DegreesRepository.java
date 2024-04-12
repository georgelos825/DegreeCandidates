package repositories;

import entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface DegreesRepository extends JpaRepository<Degree, UUID> {
    List<Degree> findByTitle(String title);
}