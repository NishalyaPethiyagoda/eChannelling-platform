package com.authentication_authorization.Login.Repositories;


import com.authentication_authorization.Login.Model.UserAccount;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UserAccountRepo extends JpaRepository<UserAccount, UUID> {

    Optional<UserAccount> findById(UUID id);
    Optional<UserAccount> findByName(String name); 
    Optional<UserAccount> findByNicNumber(String nicNumber);
}
