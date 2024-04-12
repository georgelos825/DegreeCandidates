package services;
import entities.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.DegreesRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DegreeService {
    private final DegreesRepository degreesRepository;

    @Autowired
    public DegreeService(DegreesRepository degreesRepository) {
        this.degreesRepository = degreesRepository;
    }

    public void addDegree(Degree degree) {
        degreesRepository.save(degree);
    }

    public void deleteDegree(UUID id) {
        degreesRepository.deleteById(id);
    }

    public List<Degree> searchByTitle(String title) {
        return degreesRepository.findByTitle(title);
    }

    public List<Degree> getAllDegrees() {
        return degreesRepository.findAll();
    }

    public Optional<Degree> getDegree(UUID id) {
        return degreesRepository.findById(id);
    }
}