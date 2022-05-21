package mark1708.com.repo;

import mark1708.com.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("FROM Book ORDER BY pubDate DESC")
    List<Book> findBooksSortedByPubDate();

    @Query("FROM Book WHERE isBestseller = 1")
    List<Book> findBestsellerBooks();
}
