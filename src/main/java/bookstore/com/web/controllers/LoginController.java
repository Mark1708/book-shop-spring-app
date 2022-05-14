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
@RequestMapping(value = "/login")
public class LoginController {
    private final Logger logger = Logger.getLogger(LoginController.class);
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public String login(Model model) {
        logger.info("GET /login returns login_page");

        model.addAttribute("user", new User());

        return "login_page";
    }

    @PostMapping(value = "/auth")
    public String authenticate(User user) {
        if (loginService.authenticate(user)) {
            logger.info("Login OK redirect to book shelf");
            return "redirect:/books/shelf";
        } else {
            logger.info("Login FAIL redirect back to login");
            return "redirect:/login";
        }
    }
}
