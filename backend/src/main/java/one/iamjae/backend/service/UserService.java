package one.iamjae.backend.service;


import one.iamjae.backend.model.User;
import one.iamjae.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User getUser() {
        return repo.find();
    }
}
