
package ca.uottawa.seg2505.groupe37.ujay_backend.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ca.uottawa.seg2505.groupe37.ujay_backend.model.User;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.Role;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService() {
        User admin = new User(
            "admin",
            "admin123",
            null,
            Role.ADMINISTRATOR
        );

        users.add(admin);
    }

    public List<User> getAllUsers() {
        return users;
    }
    
public boolean registerUser(String username, String password,
                            String phoneNumber) {

    // Verifier les champs obligatoires
    if (username == null || username.isBlank()) {
        return false;
    }

    if (password == null || password.isBlank()) {
        return false;
    }

    // Verifier si le nom d'utilisateur existe deja
    for (User user : users) {
        if (user.getUsername().equals(username)) {
            return false;
        }
    }
// Hacher le mot de passe avant de creer l'utilisateur
String hashedPassword = passwordEncoder.encode(password);
    User newUser = new User(
        username,
        password,
        phoneNumber,
        Role.WRITER
    );

    users.add(newUser);

    return true;
}



}

