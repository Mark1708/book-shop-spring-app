package mark1708.com.service;

import mark1708.com.model.Genre;
import mark1708.com.model.mapper.GenreRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenresService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GenresService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getGenresByParentId(Integer parentId) {
        List<Genre> genres = jdbcTemplate.query("SELECT * FROM genre WHERE parent_id = " + parentId, new GenreRowMapper());
        return new ArrayList<>(genres);
    }

    public List<Genre> getParentGenresList() {
        List<Genre> genres = jdbcTemplate.query("SELECT * FROM genre WHERE parent_id IS NULL", new GenreRowMapper());
        genres.stream().parallel().forEach(genre -> {
            List<Genre> genresByParentId = getGenresByParentId(genre.getId());
            genre.setChildGenreList(genresByParentId);
        });
        return new ArrayList<>(genres);
    }
}
