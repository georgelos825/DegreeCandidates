package services;

import entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.CandidateRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CandidateService {
    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void removeCandidate(UUID id) {
        candidateRepository.deleteById(id);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public List<Candidate> searchByDegree(UUID degreeId) {
        return candidateRepository.findByDegreeId(degreeId);
    }

    public List<Candidate> searchByName(String name) {
        return candidateRepository.findByName(name);
    }

    public List<Candidate> searchByAccepted(boolean accepted) {
        return candidateRepository.findByAccepted(accepted);
    }

    public Optional<Candidate> getCandidate(UUID id) {
        return candidateRepository.findById(id);
    }
}
