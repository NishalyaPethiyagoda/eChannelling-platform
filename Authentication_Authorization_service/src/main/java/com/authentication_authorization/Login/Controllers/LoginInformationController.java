package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.LoginInformation;
import com.authentication_authorization.Login.Repositories.LoginInformationRepo;
import com.authentication_authorization.Login.RequestObjects.LoginRequest;
import com.authentication_authorization.Login.ResponseObjects.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class LoginInformationController {

    // @Autowired
    // LoginInformationRepo repo;

    @Autowired
    private LoginInformationRepo loginInformationRepo;

    @PostMapping("/authenticate_user")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Optional<LoginInformation> loginInfoOptional = loginInformationRepo.findByUsername(loginRequest.getUsername());
        

        if (loginInfoOptional.isPresent()) {
            LoginInformation loginInformation = loginInfoOptional.get();
            LoginResponse user = new LoginResponse();
            user.setId(loginInformation.getId() );

            if (loginRequest.getPassword().equals(loginInformation.getPassword())) {

                String role = loginInformation.getRole();
                user.setRole(role);
                
                //Authorization
                if(Objects.equals(role, "admin")){
                    user.setUserRoles(List.of("Register_user", "Lab_reports", "Appointments", "Schedule"));
                    return ResponseEntity.ok(user);
                }
                if(Objects.equals(role, "doctor") || Objects.equals(role, "patient")){
                    user.setUserRoles(List.of("Lab_reports", "Appointments", "Schedule"));
                    return ResponseEntity.ok(user);
                }
                if(Objects.equals(role, "lab_assistant")){
                    user.setUserRoles(List.of("Lab_reports"));
                    return ResponseEntity.ok(user);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}