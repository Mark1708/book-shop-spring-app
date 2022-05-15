package bookstore.com.app.services;

import bookstore.com.web.dto.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository implements ProjectRepository<Book>, ApplicationContextAware {

    private final Logger logger = Logger.getLogger(BookRepository.class);
    //private final List<Book> repo = new ArrayList<>();
    private ApplicationContext context;

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> retreiveAll() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper(Book.class));
        return new ArrayList<>(books);
    }

    @Override
    public void store(Book book) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("author",book.getAuthor());
        parameterSource.addValue("title",book.getTitle());
        parameterSource.addValue("size",book.getSize());
        jdbcTemplate.update("INSERT INTO books(author,title,size) VALUES(:author, :title, :size)",parameterSource);
        logger.info("store new book: " + book);
    }

    @Override
    public boolean removeItemById(Integer bookIdToRemove) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id",bookIdToRemove);
        jdbcTemplate.update("DELETE FROM books WHERE id = :id",parameterSource);
        logger.info("remove book completed");
        return true;
    }

    @Override
    public List<Book> getFilteredBooks(Book book) {
        if(!book.getAuthor().equals("")){
            logger.info("filtered book by author completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("author", book.getAuthor());
            List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE author = :author", namedParameters, new BeanPropertyRowMapper(Book.class));
            return new ArrayList<>(books);
        } else if(!book.getTitle().equals("")){
            logger.info("filtered book by title completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("title", book.getTitle());
            List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE title = :title", namedParameters, new BeanPropertyRowMapper(Book.class));
            return new ArrayList<>(books);
        } else if(book.getSize() != null){
            logger.info("filtered book by size completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("size", book.getSize());
            List<Book> books = jdbcTemplate.query("SELECT * FROM books WHERE size = :size", namedParameters, new BeanPropertyRowMapper(Book.class));
            return new ArrayList<>(books);
        }
        return new ArrayList<>();
    }

    @Override
    public boolean removeItemByRegex(Book book) {
        if(!book.getAuthor().equals("")){
            logger.info("filtered book by author completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("author", book.getAuthor());
            jdbcTemplate.update("DELETE FROM books WHERE author = :author", namedParameters);
        } else if(!book.getTitle().equals("")){
            logger.info("filtered book by title completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("title", book.getTitle());
            jdbcTemplate.update("DELETE FROM books WHERE title = :title", namedParameters);
        } else if(book.getSize() != null){
            logger.info("filtered book by size completed: " + book);
            SqlParameterSource namedParameters = new MapSqlParameterSource()
                    .addValue("size", book.getSize());
            jdbcTemplate.update("DELETE FROM books WHERE size = :size", namedParameters);
        }
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    public void defaultInit(){
        logger.info("default INIT in book repo bean");
    }

    public void defaultDestroy(){
        logger.info("default DESTROY in book repo bean");
    }
}
