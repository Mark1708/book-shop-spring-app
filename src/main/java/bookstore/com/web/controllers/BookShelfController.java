package bookstore.com.web.controllers;


import bookstore.com.app.service.BookService;
import bookstore.com.web.dto.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="books")
public class BookShelfController {
    private final Logger logger = Logger.getLogger(BookShelfController.class);
    private final BookService bookService;

    @Autowired
    public BookShelfController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/shelf")
    public String books(Model model) {
        logger.info("got book shelf");

        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.getAllBooks());

        return "book_shelf";
    }

    @PostMapping(value = "/save")
    public String saveBook(Book book) {
        bookService.saveBook(book);

        logger.info("Current repository size: " + bookService.getAllBooks().size());

        return "redirect:/books/shelf";
    }

    @PostMapping(value =  "/remove")
    public String removeBook(@RequestParam(value = "bookData") String bookData, @RequestParam(value = "typeSearch") String typeSearch) {
        if (bookService.removeBook(bookData, typeSearch)) {
            return "redirect:/books/shelf";
        } else {
            return "book_shelf";
        }
    }

    @PostMapping("/search")
    public String searchBooks(@RequestParam(value = "bookData") String bookData, @RequestParam(value = "typeSearch") String typeSearch, Model model) {
        model.addAttribute("bookList", bookService.searchBook(bookData, typeSearch));
        if (bookService.searchBook(bookData, typeSearch).size() > 0) {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.searchBook(bookData, typeSearch));
        } else {
            model.addAttribute("book", new Book());
            model.addAttribute("bookList", bookService.getAllBooks());
        }
        return "book_shelf";
    }
}
