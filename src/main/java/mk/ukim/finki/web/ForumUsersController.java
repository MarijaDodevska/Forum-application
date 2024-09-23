package mk.ukim.finki.web;

import mk.ukim.finki.model.ForumUser;
import mk.ukim.finki.service.ForumUserService;
import mk.ukim.finki.service.InterestService;
import mk.ukim.finki.model.ForumUserType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
@Controller
public class ForumUsersController {

    private final ForumUserService service;
    private final InterestService interestService;

    public ForumUsersController(ForumUserService service, InterestService skillService) {
        this.service = service;
        this.interestService = skillService;
    }

    @GetMapping(value = {"/", "/users"})
    public String showList(@RequestParam(required = false) Long interestId,
                           @RequestParam(required = false) Integer age,
                           Model model) {
        List<ForumUser> forumUsers;
        if (interestId == null && age == null) {
            forumUsers = this.service.listAll();
        } else {
            forumUsers = this.service.filter(interestId, age);
        }
        model.addAttribute("users", forumUsers);
        model.addAttribute("interests", interestService.listAll());
        return "list";
    }

    @GetMapping("/users/add")
    public String showAdd(Model model) {
        model.addAttribute("interests", interestService.listAll());
        model.addAttribute("types", ForumUserType.values());
        return "form";
    }

    @GetMapping("/users/{id}/edit")

    public String showEdit(@PathVariable Long id,
                           Model model) {
        model.addAttribute("user", service.findById(id));
        model.addAttribute("interests", interestService.listAll());
        model.addAttribute("types", ForumUserType.values());
        return "form";    }

    @PostMapping("/users")
    public String create(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam ForumUserType type,
                         @RequestParam List<Long> interestId,
                         @RequestParam LocalDate birthday) {
        this.service.create(name, email, password, type, interestId, birthday);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}")
    public String update(@PathVariable Long id,
                         @RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password,
                         @RequestParam ForumUserType type,
                         @RequestParam List<Long> interestId,
                         @RequestParam LocalDate birthday) {
        this.service.update(id, name, email, password, type, interestId, birthday);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.service.delete(id);
        return "redirect:/users";
    }
}
