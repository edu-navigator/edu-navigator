package org.edunavigator.authentication_service.services;

import jakarta.ws.rs.core.Response;
import org.edunavigator.authentication_service.models.LoginResponse;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KeycloakService {
    @Value("${keycloak.auth-server-url}")
    private String keycloakServerUrl;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.client-secret}")
    private String clientSecret;

    private Keycloak getInstance() {
        return KeycloakBuilder.builder()
                .serverUrl(keycloakServerUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType("client_credentials")
                .build();
    }

    public String registerUser(String username, String email, String firstName, String lastName, String password) {
        Keycloak keycloak = getInstance();
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        // Create user
        UserRepresentation user = new UserRepresentation();
        user.setUsername(username);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEnabled(true);

        Response response = usersResource.create(user);
        if (response.getStatus() == 201) {
            String userId = response.getLocation().getPath().replaceAll(".*/([^/]+)$", "$1");

            CredentialRepresentation passwordCredential = new CredentialRepresentation();
            passwordCredential.setTemporary(false);
            passwordCredential.setType(CredentialRepresentation.PASSWORD);
            passwordCredential.setValue(password);

            usersResource.get(userId).resetPassword(passwordCredential);
            return "User registered successfully";
        } else {
            throw new RuntimeException("Error registering user: " + response.getStatusInfo().toString());
        }
    }

    public LoginResponse loginUser(String username, String password) {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(keycloakServerUrl)
                .realm(realm)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .grantType("password")
                .username(username)
                .password(password)
                .build();
        try {
            AccessTokenResponse tokenResponse = keycloak.tokenManager().getAccessToken();
            return new LoginResponse(tokenResponse.getToken(),tokenResponse.getRefreshToken());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid username or password");
        }
    }

    public String logoutUser(String refreshToken){
        Keycloak keycloak = getInstance();
        try{
            keycloak.tokenManager().invalidate(refreshToken);
            return  "User logged out "+new Date();
        }catch (Exception ex){
            ex.printStackTrace();
            throw new RuntimeException("Error logging out user: " + ex.getMessage());
        }
    }
}
