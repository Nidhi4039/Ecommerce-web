package learn.com.ecommerce.service;

import learn.com.ecommerce.jwt.JwtUtil;
import learn.com.ecommerce.model.User;
import learn.com.ecommerce.repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Optional;
import java.util.PrimitiveIterator;

@Service
public class AuthService {
   private AuthRepository repository;
   private PasswordEncoder passwordEncoder;
   private JwtUtil jwtUtil;

   public AuthService() {
    }
    public AuthService(AuthRepository repository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }
    public String authenticate(String email, String password){
        Optional<User> user = repository.findByEmail(email);

        if(user.isEmpty())return "Authentication Failed";
        boolean matches = passwordEncoder.matches(password, user.get().getPassword());
        if(!matches)return "Authentication Failed";
        return jwtUtil.generateToken(user.get());
    }

    public String register(User user){
        Optional<User> existingUser = repository.findByEmail(user.getEmail());
        if(existingUser.isPresent())return "User already exists";
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repository.save(user);
        return "User registered successfully";
    }

}
