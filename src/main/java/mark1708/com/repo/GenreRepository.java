package mark1708.com.repo;

import mark1708.com.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    List<Genre> findGenreByParentId(Integer parentId);

    @Query("FROM Genre WHERE parentId IS NULL")
    List<Genre> findParentGenres();
}
