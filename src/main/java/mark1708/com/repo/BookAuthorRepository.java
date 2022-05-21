package mark1708.com.repo;

import mark1708.com.model.BookAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {

    List<BookAuthor> findAllByAuthor_Id(Integer authorId);

    Optional<BookAuthor> findAllByBook_Id(Integer bookId);
}
