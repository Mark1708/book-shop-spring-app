package mark1708.com.service;

import mark1708.com.model.Author;
import mark1708.com.model.mapper.AuthorRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Author> getAuthorList(){
        List<Author> authors = jdbcTemplate.query("SELECT * FROM author ORDER BY name", new AuthorRowMapper());
        return new ArrayList<>(authors);
    }

    public Map<String, List<Author>> getAuthorsSortedMap() {
        Map<String, List<Author>> map = getAuthorList()
                .stream()
                .sorted(Comparator.comparing(Author::getName))
                .collect(Collectors.groupingBy(Author::getFirstLetter));
        return map;
    }
}
