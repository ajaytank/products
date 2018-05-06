package hello.service;

import hello.dto.LoginRequest;
import hello.model.User;
import hello.repository.UserRepository;
import hello.utils.exception.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public String login(LoginRequest loginRequest) {
        String emailId = loginRequest.getEmailId();
        String password = loginRequest.getPassword();
        User user = userRepository.findByEmailId(emailId);

        if (user != null && user.getPassword() != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return "Success";
            }
        }
        return "Failed";
    }

    public void signUp(User user) {
        if (user == null || user.getEmailId() == null) {
            throw new APIException("user not found");
        }
        User userTemp = userRepository.findByEmailId(user.getEmailId());
        if (userTemp != null) {
            throw new APIException("user already exist");
        }

        String password = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }
}
