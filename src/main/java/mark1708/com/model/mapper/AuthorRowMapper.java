package mark1708.com.model.mapper;

import mark1708.com.model.Author;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author();
        author.setId(rs.getInt("id"));
        author.setSlug(rs.getString("slug"));
        author.setName(rs.getString("name"));
        author.setDescription(rs.getString("description"));
        return author;
    }
}
