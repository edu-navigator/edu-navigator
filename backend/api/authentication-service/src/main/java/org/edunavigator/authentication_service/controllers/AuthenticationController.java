package org.edunavigator.authentication_service.controllers;
import org.edunavigator.authentication_service.dto.UserDTO;
import org.edunavigator.authentication_service.models.LoginResponse;
import org.edunavigator.authentication_service.services.KeycloakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

    @Autowired
    private KeycloakService keycloakService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO){
        String result = keycloakService.registerUser(userDTO.getUsername(), userDTO.getEmail(),
                    userDTO.getFirstName(), userDTO.getLastName(), userDTO.getPassword());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserDTO userDTO){
        LoginResponse result = keycloakService.loginUser(userDTO.getUsername(), userDTO.getPassword());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> login(@RequestBody String refreshToke){
        String result = keycloakService.logoutUser(refreshToke);
        return ResponseEntity.ok(result);
    }
}
