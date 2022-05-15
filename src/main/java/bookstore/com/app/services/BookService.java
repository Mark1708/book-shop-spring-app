package bookstore.com.app.services;

import org.apache.log4j.Logger;
import bookstore.com.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final ProjectRepository<Book> bookRepo;
    private final Logger logger = Logger.getLogger(BookService.class);

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retreiveAll();
    }

    public void saveBook(Book book) {
        bookRepo.store(book);
    }

    public boolean removeBookById(Integer bookIdToRemove) {
        return bookRepo.removeItemById(bookIdToRemove);
    }

    public void defaultInit(){
        logger.info("default INIT in book service");
    }

    public void defaultDestroy(){
        logger.info("default DESTROY in book service");
    }

    public List<Book> getFilteredBooks(Book book) {
        return bookRepo.getFilteredBooks(book);
    }

    public boolean removeBookByRegex(Book book) {
        return bookRepo.removeItemByRegex(book);
    }
}
