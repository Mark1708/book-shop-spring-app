package bookstore.com.web.controllers;


import bookstore.com.app.service.LoginService;
import bookstore.com.web.dto.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {
    private final Logger logger = Logger.getLogger(LoginController.class);
    private final LoginService registrationService;

    @Autowired
    public RegistrationController(LoginService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String login(Model model) {
        logger.info("GET /registration returns registration_page");

        model.addAttribute("user", new User());

        return "registration_page";
    }

    @PostMapping(value = "/auth")
    public String register(User user) {
        if (registrationService.register(user)) {
            logger.info("Registration OK redirect to login");
            return "redirect:/login";
        } else {
            logger.info("Login FAIL redirect back to registration");
            return "redirect:/registration";
        }
    }
}
