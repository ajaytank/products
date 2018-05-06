package hello.service;

import hello.dto.LoginRequest;
import hello.model.User;
import hello.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public String login(LoginRequest loginRequest) {
        String emailId = loginRequest.getEmailId();
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmailId(emailId);
        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            return "Success";
        } else {
            return "Failed";
        }
    }
}
