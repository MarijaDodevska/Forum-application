package mk.ukim.finki.service.impl;

import mk.ukim.finki.model.exceptions.InvalidInterestIdException;
import mk.ukim.finki.repository.InterestRepository;
import mk.ukim.finki.service.InterestService;
import mk.ukim.finki.model.Interest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InterestServiceImpl implements InterestService {
    private final InterestRepository interestRepository;

    public InterestServiceImpl(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Override
    public Interest findById(Long id) {
        return interestRepository.findById(id).orElseThrow(InvalidInterestIdException::new);
    }

    @Override
    public List<Interest> listAll() {
        return interestRepository.findAll();
    }

    @Override
    public Interest create(String name) {
        return interestRepository.save(new Interest(name));
    }
}
