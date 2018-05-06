package hello.repository;

import hello.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public User findByEmailId(String emailId);
}
