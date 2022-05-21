package mark1708.com.service;

import mark1708.com.dto.BookDto;
import mark1708.com.exception.ResourceNotFoundException;
import mark1708.com.model.Book;
import mark1708.com.model.BookAuthor;
import mark1708.com.repo.BookAuthorRepository;
import mark1708.com.repo.BookRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static mark1708.com.exception.ErrorMessage.NO_FOUND_BY_ID_ERROR;

@Service
public class BookService {

    private BookRepository bookRepository;
    private BookAuthorRepository bookAuthorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, BookAuthorRepository bookAuthorRepository) {
        this.bookRepository = bookRepository;
        this.bookAuthorRepository = bookAuthorRepository;
    }

    public List<BookDto> getBooksList(){
        return convertToDto(bookRepository.findAll());
    }

    public List<BookDto> getNewBooksList() {
        return convertToDto(bookRepository.findBooksSortedByPubDate());
    }

    public List<BookDto> getPopularBooksList() {
        return convertToDto(bookRepository.findBestsellerBooks());
    }

    public BookDto convertToDto(Book book) {
        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book, bookDto);
        BookAuthor bookAuthor = bookAuthorRepository
                .findAllByBook_Id(book.getId())
                .orElseThrow(() -> new ResourceNotFoundException(NO_FOUND_BY_ID_ERROR + book.getId()));
        bookDto.setAuthor(bookAuthor.getAuthor());
        return bookDto;
    }

    public List<BookDto> convertToDto(List<Book> books) {
        return books.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
