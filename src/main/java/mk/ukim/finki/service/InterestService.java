package mk.ukim.finki.service;

import mk.ukim.finki.model.Interest;
import mk.ukim.finki.model.exceptions.InvalidInterestIdException;

import java.util.List;

public interface InterestService {
    Interest findById(Long id);
    List<Interest> listAll();
    Interest create(String name);
}
