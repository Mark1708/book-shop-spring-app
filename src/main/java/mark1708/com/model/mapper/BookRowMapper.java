package mark1708.com.model.mapper;

import mark1708.com.model.Author;
import mark1708.com.model.Book;
import mark1708.com.model.BookAuthor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookRowMapper implements RowMapper<Book> {

    private JdbcTemplate jdbcTemplate;
    public BookRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        try {
            book.setPubDate(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("pub_date")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        book.setIsBestseller(rs.getInt("is_bestseller"));
        book.setSlug(rs.getString("slug"));
        book.setTitle(rs.getString("title"));
        book.setImage(rs.getString("image"));
        book.setDescription(rs.getString("description"));
        book.setPrice(rs.getInt("price"));
        book.setDiscount(rs.getInt("discount"));
        book.setAuthor(getAuthor(book.getId()));
        return book;
    }

    private Author getAuthor(Integer bookId) {
        String sql = "SELECT * FROM book2author WHERE book_id = ?";

        BookAuthor bookAuthor = (BookAuthor) jdbcTemplate.queryForObject(
                sql, new Object[] { bookId }, new BeanPropertyRowMapper(BookAuthor.class)
        );

        Author author = (Author) jdbcTemplate.queryForObject(
                "SELECT * FROM author WHERE id = ?"
                , new Object[] { bookAuthor.getAuthor_id() }, new BeanPropertyRowMapper(Author.class)
        );
        return author;
    }
}
