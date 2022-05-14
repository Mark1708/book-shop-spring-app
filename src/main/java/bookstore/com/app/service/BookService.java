package bookstore.com.app.service;


import bookstore.com.app.repo.ProjectRepository;
import bookstore.com.web.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final ProjectRepository<Book> bookRepo;

    @Autowired
    public BookService(ProjectRepository<Book> bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.retrieveAll();
    }

    public void saveBook(Book book) {
        if (!"".equals(book.getAuthor()) || book.getSize() != null || !"".equals(book.getTitle())) {
            bookRepo.store(book);
        }
    }

    public boolean removeBook(final String bookData, final String typeSearch) {
        ArrayList<Boolean> del = new ArrayList<>();
        // Determine by what parameter the book will be deleted
        switch (typeSearch){
            case "id":
                // Checking the presence of the book in the database
                if (getAllBooks().stream().anyMatch(book -> book.getId() == Integer.parseInt(bookData))){
                    // Delete by ID if there was a corresponding parameter or looking for it by other parameters and also delete
                    return bookRepo.removeItemById(Integer.valueOf(bookData));
                }
                break;
            case "author":
                if(getAllBooks().stream().anyMatch(book -> book.getAuthor().equals(bookData))){
                    getAllBooks().stream().filter(book -> book.getAuthor().equals(bookData)).forEach(book -> del.add(bookRepo.removeItemById(book.getId())));
                }
                // Check that all the necessary objects have been deleted
                return checkSuccesses(del);
            case "title":
                if(getAllBooks().stream().anyMatch(book -> book.getTitle().equals(bookData))){
                    getAllBooks().stream().filter(book -> book.getTitle().equals(bookData)).forEach(book -> del.add(bookRepo.removeItemById(book.getId())));
                }
                return checkSuccesses(del);
            case "size":
                if(getAllBooks().stream().anyMatch(book -> book.getSize() == Integer.parseInt(bookData))){
                    getAllBooks().stream().filter(book -> book.getSize() == Integer.parseInt(bookData)).forEach(book -> del.add(bookRepo.removeItemById(book.getId())));
                }
                return checkSuccesses(del);
        }

        return false;
    }


    private boolean checkSuccesses(ArrayList<Boolean> arrayList){
        AtomicBoolean flag = new AtomicBoolean(true);
        arrayList.forEach( el -> {
            if (!el) {
                flag.set(false);
            }
        });
        return flag.get();
    }

    public List<Book> searchBook(final String bookData, final String typeSearch){
        // Determine by what parameter the book will be search
        switch (typeSearch){
            case "id":
                // Returning found books
                return getAllBooks().stream().filter(book -> book.getId() == Integer.parseInt(bookData)).collect(Collectors.toList());
            case "author":
                return getAllBooks().stream().filter(book -> book.getAuthor().equals(bookData)).collect(Collectors.toList());
            case "title":
                return getAllBooks().stream().filter(book -> book.getTitle().equals(bookData)).collect(Collectors.toList());
            case "size":
                return getAllBooks().stream().filter(book -> book.getSize() == Integer.parseInt(bookData)).collect(Collectors.toList());
        }
        return getAllBooks();
    }
}
