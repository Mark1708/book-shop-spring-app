package mark1708.com.service;

import mark1708.com.model.Author;
import mark1708.com.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAuthorList(){
        return authorRepository.findAll();
    }

    public Map<String, List<Author>> getAuthorsSortedMap() {
        return authorRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Author::getName))
                .collect(Collectors.groupingBy(Author::getFirstLetter));
    }
}
