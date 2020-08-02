package OpenCode.Webapp.Controllers;

import OpenCode.Webapp.Repository.UserRepository;
import OpenCode.Webapp.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Controller
public class AuthorizationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(name = "error", required = false) Boolean error,
                        Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "authorization";
    }

    @GetMapping("/registration/add")
    public String authorization(Model model){
        model.addAttribute("reg","Регистрация");
        return "registration";
    }

    @PostMapping("/registration/add")
    public String registration(@RequestParam String login, @RequestParam String password, Model model){
        User user = new User(login,password);
        userRepository.save(user);
        return "redirect:/rating";
    }

    @GetMapping("/rating")
    public String rating(Model model){
        model.addAttribute("rat","Рэйтинг");
        return "rating";
    }
}
