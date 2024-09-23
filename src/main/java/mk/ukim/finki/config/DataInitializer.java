package mk.ukim.finki.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.model.ForumUserType;
import mk.ukim.finki.model.Interest;
import mk.ukim.finki.service.ForumUserService;
import mk.ukim.finki.service.InterestService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class DataInitializer {

    private final InterestService interestService;

    private final ForumUserService service;

    public DataInitializer(InterestService interestService, ForumUserService service) {
        this.interestService = interestService;
        this.service = service;
    }

    private ForumUserType randomizeType(int i) {
        if (i % 3 == 0) return ForumUserType.GOLDEN;
        else if (i % 3 == 1) return ForumUserType.ROLE_ADMIN;
        return ForumUserType.REGULAR;
    }
    @PostConstruct
    public void initData() {
        for (int i = 1; i < 6; i++) {
            this.interestService.create("Interest: " + i);
        }

        List<Interest> interests = this.interestService.listAll();
        for (int i = 1; i < 11; i++) {
            this.service.create(
                    "ForumUser: " + i,
                    "user." + i + "@wp.finki.ukim.mk",
                    "forumUser" + i,
                    this.randomizeType(i),
                    Stream.of(interests.get((i - 1) % 5).getId(), interests.get((i + 1) % 5).getId()).collect(Collectors.toList()),
                    LocalDate.now().minusYears((i + 1) * 5)
            );
        }
    }
}
