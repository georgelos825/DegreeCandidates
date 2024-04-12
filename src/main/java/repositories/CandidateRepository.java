package repositories;

import entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {
    List<Candidate> findByDegreeId(UUID degreeId);
    List<Candidate> findByName(String name);
    List<Candidate> findByAccepted(boolean accepted);
}
