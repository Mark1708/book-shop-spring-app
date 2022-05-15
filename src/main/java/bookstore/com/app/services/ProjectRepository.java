package bookstore.com.app.services;

import java.util.List;

public interface ProjectRepository<T> {
    List<T> retreiveAll();

    void store(T book);

    boolean removeItemById(Integer bookIdToRemove);

    List<T> getFilteredBooks(T book);

    boolean removeItemByRegex(T book);
}
