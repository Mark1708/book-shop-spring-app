package mark1708.com.service;

import mark1708.com.model.Book;
import mark1708.com.model.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksList(){
        List<Book> books = jdbcTemplate.query("SELECT * FROM book LIMIT 15", new BookRowMapper(jdbcTemplate));
        return new ArrayList<>(books);
    }

    public List<Book> getNewBooksList() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM book ORDER BY pub_date DESC LIMIT 15", new BookRowMapper(jdbcTemplate));
        return new ArrayList<>(books);
    }

    public List<Book> getPopularBooksList() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM book WHERE is_bestseller = 1 LIMIT 15", new BookRowMapper(jdbcTemplate));
        return new ArrayList<>(books);
    }
}
