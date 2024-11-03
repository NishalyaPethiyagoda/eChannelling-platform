package com.authentication_authorization.Login.Controllers;

import com.authentication_authorization.Login.Model.UserAccount;
import com.authentication_authorization.Login.Repositories.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserAccountController {

    @Autowired
    private UserAccountRepo repo;

    @GetMapping("/getUserByNic/{nicNumber}")
    public ResponseEntity<UserAccount> getUserByNic(@PathVariable String nicNumber){
        Optional<UserAccount> user = repo.findByNicNumber(nicNumber);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable UUID id){
        Optional<UserAccount> user = repo.findById(id);

        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user.get());
    }
}
