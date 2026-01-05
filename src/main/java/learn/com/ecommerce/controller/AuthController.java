package learn.com.ecommerce.controller;

import learn.com.ecommerce.model.User;
import learn.com.ecommerce.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private AuthService service;
    public AuthController(AuthService service) {
        this.service = service;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
            // Registration logic here
            service.register(user);
            return ResponseEntity.created(null).body("User registered successfully");
    }

    @GetMapping("/")
    public String home()
    {
        return "Welcome to Spring boot application";
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
            // Authentication logic here
            String token = service.authenticate(user.getEmail(), user.getPassword());
            return ResponseEntity.ok(token);
    }
}
