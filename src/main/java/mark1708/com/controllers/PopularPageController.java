package mark1708.com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books/popular")
public class PopularPageController {
    @GetMapping()
    public String viewPage(Model model){
        return "books/popular";
    }
}
