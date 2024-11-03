package com.authentication_authorization.Login.Repositories;

import com.authentication_authorization.Login.Model.LoginInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestResource
public interface LoginInformationRepo extends JpaRepository<LoginInformation, UUID> {
    Optional<LoginInformation> findByUsername(String username);
}
