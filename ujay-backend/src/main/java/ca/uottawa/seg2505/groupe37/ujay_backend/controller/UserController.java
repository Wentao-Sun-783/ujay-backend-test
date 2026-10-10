package ca.uottawa.seg2505.groupe37.ujay_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.uottawa.seg2505.groupe37.ujay_backend.model.AdminCreateModeratorRequest;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.LoginRequest;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.RegisterRequest;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.User;
import ca.uottawa.seg2505.groupe37.ujay_backend.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/status")
    public String getStatus() {
        return "Le backend uJay fonctionne !";
    }

    @GetMapping("/api/users/count")
    public int countUsers() {
        return userService.getAllUsers().size();
    }

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/api/register")
    public String registerUser(@RequestBody RegisterRequest request) {

        boolean success = userService.registerUser(
            request.getUsername(),
            request.getPassword(),
            request.getPhoneNumber()
        );

        if (success) {
            return "Inscription reussie !";
        } else {
            return "Inscription refusee : informations invalides ou nom deja utilise.";
        }
    }

    @PostMapping("/api/admin/login")
    public String adminLogin(@RequestBody LoginRequest request) {

        boolean success = userService.authenticateAdmin(
            request.getUsername(),
            request.getPassword()
        );

        if (success) {
            return "Connexion administrateur reussie !";
        } else {
            return "Connexion administrateur refusee.";
        }
    }

    @PostMapping("/api/admin/moderators")
    public String addModerator(@RequestBody AdminCreateModeratorRequest request) {

        boolean isAdmin = userService.authenticateAdmin(
            request.getAdminUsername(),
            request.getAdminPassword()
        );

        if (!isAdmin) {
            return "Acces refuse : administrateur requis.";
        }

        boolean success = userService.addModerator(
            request.getUsername(),
            request.getPassword(),
            request.getPhoneNumber()
        );

        if (success) {
            return "Moderator ajoute avec succes !";
        } else {
            return "Ajout du Moderator refuse.";
        }
    }

    @GetMapping("/api/admin/users")
    public List<User> getModeratorsAndWriters() {
        return userService.getModeratorsAndWriters();
    }
}