package mark1708.com.controllers;

import mark1708.com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String viewPage(Model model){
        model.addAttribute("bookData", bookService.getBooksList().subList(0, 15));
        model.addAttribute("newBookData", bookService.getNewBooksList().subList(0, 15));
        model.addAttribute("popularBookData", bookService.getPopularBooksList().subList(0, 15));
        return "index";
    }
}
