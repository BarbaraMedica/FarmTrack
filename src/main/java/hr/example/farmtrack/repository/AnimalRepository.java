package hr.example.farmtrack.repository;

import hr.example.farmtrack.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByImeContainingIgnoreCase(String ime);
}
