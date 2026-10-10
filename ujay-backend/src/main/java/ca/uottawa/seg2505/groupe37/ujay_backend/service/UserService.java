package ca.uottawa.seg2505.groupe37.ujay_backend.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ca.uottawa.seg2505.groupe37.ujay_backend.model.Role;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.User;
import ca.uottawa.seg2505.groupe37.ujay_backend.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();

        if (!userRepository.existsById("admin")) {
            User admin = new User(
                "admin",
                passwordEncoder.encode("admin-pwd"),
                null,
                Role.ADMINISTRATOR
            );

            userRepository.save(admin);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean registerUser(String username,
                                String password,
                                String phoneNumber) {

        if (username == null || username.isBlank()) {
            return false;
        }

        if (password == null || password.isBlank()) {
            return false;
        }

        if (userRepository.existsById(username)) {
            return false;
        }

        String hashedPassword = passwordEncoder.encode(password);

        User newUser = new User(
            username,
            hashedPassword,
            phoneNumber,
            Role.WRITER
        );

        userRepository.save(newUser);

        return true;
    }
}