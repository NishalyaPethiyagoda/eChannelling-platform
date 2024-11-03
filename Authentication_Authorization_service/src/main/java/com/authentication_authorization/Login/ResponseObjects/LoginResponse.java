package com.authentication_authorization.Login.ResponseObjects;

import java.util.List;
import java.util.UUID;

public class LoginResponse {
    
    UUID id;
    String role;
    List<String> userRoles;
    
    public UUID getId() {
        return id;
    }
    public String getRole(){
        return role;
    }
    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }
}