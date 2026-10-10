
package ca.uottawa.seg2505.groupe37.ujay_backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ca.uottawa.seg2505.groupe37.ujay_backend.model.RegisterRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
