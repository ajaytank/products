package hello.controller;

import hello.dto.LoginRequest;
import hello.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}
