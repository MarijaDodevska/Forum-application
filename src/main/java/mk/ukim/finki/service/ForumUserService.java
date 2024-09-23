package mk.ukim.finki.service;

import mk.ukim.finki.model.ForumUser;
import mk.ukim.finki.model.ForumUserType;
import mk.ukim.finki.model.exceptions.InvalidForumUserIdException;
import mk.ukim.finki.model.exceptions.InvalidInterestIdException;

import java.time.LocalDate;
import java.util.List;

public interface ForumUserService {

    List<ForumUser> listAll();
    ForumUser findById(Long id);
    ForumUser create(String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday);
    ForumUser update(Long id, String name, String email, String password, ForumUserType type, List<Long> interestId, LocalDate birthday);
    ForumUser delete(Long id);
    List<ForumUser> filter(Long interestId, Integer age);
}
