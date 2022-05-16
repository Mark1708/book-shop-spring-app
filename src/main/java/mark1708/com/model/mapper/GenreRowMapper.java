package mark1708.com.model.mapper;

import mark1708.com.model.Genre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GenreRowMapper implements RowMapper<Genre> {
    @Override
    public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
        Genre genre = new Genre();
        genre.setId(rs.getInt("id"));
        genre.setParentId(rs.getInt("parent_id"));
        genre.setSlug(rs.getString("slug"));
        genre.setName(rs.getString("name"));
        return genre;
    }
}
