package com.authentication_authorization.Login.Controllers;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.authentication_authorization.Login.Model.LoginInformation;
import com.authentication_authorization.Login.Model.UserAccount;
import com.authentication_authorization.Login.Repositories.LoginInformationRepo;
import com.authentication_authorization.Login.Repositories.UserAccountRepo;
import com.authentication_authorization.Login.RequestObjects.RegisterRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegistrationController {
    
    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private LoginInformationRepo loginInformationRepo;

    @PostMapping("/register")
    public ResponseEntity<String> postMethodName(@RequestBody RegisterRequest request) {
        
        if (request.getName() == null || request.getName().isEmpty()) {
            return ResponseEntity.badRequest().body("Name cannot be null or empty");
        }
        if (request.getEmailAddress() == null || request.getEmailAddress().isEmpty()) {
            return ResponseEntity.badRequest().body("Email address cannot be null or empty");
        }
        if (request.getNicNumber() == null || request.getNicNumber().isEmpty()) {
            return ResponseEntity.badRequest().body("NIC cannot be null or empty");
        }

        if(request.getUsername() == null || request.getUsername().isEmpty() ){
            return ResponseEntity.badRequest().body("username cannot be null or empty");
        }
        if(request.getPassword() == null || request.getPassword().isEmpty() ){
            return ResponseEntity.badRequest().body("password cannot be null or empty");
        }
        if(request.getRole() == null || request.getRole().isEmpty() ){
            return ResponseEntity.badRequest().body("role cannot be null or empty");
        }
        
        Optional<UserAccount> databaseNICInfor = userAccountRepo.findByNicNumber(request.getNicNumber());
        Optional<UserAccount> databaseNameInfo = userAccountRepo.findByName(request.getName());
        Optional<LoginInformation> databaseUsernameInfo = loginInformationRepo.findByUsername(request.getUsername());

        if (databaseNICInfor.isPresent() || databaseNameInfo.isPresent() || databaseUsernameInfo.isPresent()) {
            return ResponseEntity.badRequest().body("User already exists");
        }

        UserAccount user = new UserAccount();
        
        UUID userId = UUID.randomUUID();
        user.setId(userId);
        user.setName(request.getName());
        user.setEmailAddress(request.getEmailAddress());
        user.setNicNumber(request.getNicNumber());
        userAccountRepo.save( user);

        LoginInformation loginInfo = new LoginInformation();
        loginInfo.setId(userId);
        loginInfo.setUsername(request.getUsername());
        loginInfo.setPassword(request.getPassword());
        loginInfo.setRole(request.getRole());
        loginInformationRepo.save(loginInfo);


        return ResponseEntity.ok("User registered successfully");
    }
    
}
