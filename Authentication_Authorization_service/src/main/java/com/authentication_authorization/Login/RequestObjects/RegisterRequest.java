package com.authentication_authorization.Login.RequestObjects;

public class RegisterRequest {
    
    //user account information
    String name;
    String nicNumber;
    String emailAddress;
    //login account information
    String username;
    String password;
    String role;
    
    public String getName( ){
        return name;
    }
    public String getEmailAddress( ){
        return emailAddress;
    }
    public String getNicNumber( ){
        return nicNumber;
    }
    
    public String getUsername( ){
        return username;
    }
    public String getPassword( ){
        return password;
    }
    public String getRole(){
        return role;
    }
}
