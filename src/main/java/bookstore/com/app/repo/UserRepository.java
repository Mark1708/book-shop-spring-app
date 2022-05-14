package bookstore.com.app.repo;

import bookstore.com.web.dto.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class UserRepository implements ProjectRepository<User>{

    private final Logger logger = Logger.getLogger(BookRepository.class);
    // Initialize a set to store user data so that everyone is unique
    private final Set<User> repo = new HashSet<>(Collections.singleton(new User(1, "root", "123")));

    @Override
    public List<User> retrieveAll() {
        return new ArrayList<>(repo);
    }

    @Override
    public void store(User user) {
        user.setId(user.hashCode());
        logger.info("Register new book: " + user.toString());
        repo.add(user);
    }

    @Override
    public boolean removeItemById(Integer userIdToRemove) {
        for (User user : retrieveAll()) {
            if (user.getId().equals(userIdToRemove)) {
                logger.info("Remove user - completed: " + user);
                return repo.remove(user);
            }
        }
        return false;
    }
}
