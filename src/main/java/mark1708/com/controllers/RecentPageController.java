package mark1708.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/books/recent")
public class RecentPageController {
    @GetMapping()
    public String viewPage(Model model){
        return "books/recent";
    }
}
