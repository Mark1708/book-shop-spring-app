package bookstore.com.app.service;


import bookstore.com.app.repo.ProjectRepository;
import bookstore.com.web.dto.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final Logger logger = Logger.getLogger(LoginService.class);
    private final ProjectRepository<User> userRepo;

    public LoginService(ProjectRepository<User> userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.retrieveAll();
    }

    public boolean authenticate(User user) {
        logger.info("Try auth with user-form: " + user.toString());
        for (User userInList : getAllUsers()) {
            if (user.getUsername().equals(userInList.getUsername()) && user.getPassword().equals(userInList.getPassword()))
                return true;
        }
        return false;
    }

    public boolean register(User user) {
        logger.info("Try register new user: " + user.toString());
        userRepo.store(user);
        return true;
    }
}
