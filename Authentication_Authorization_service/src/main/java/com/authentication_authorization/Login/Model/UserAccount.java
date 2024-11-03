package com.authentication_authorization.Login.Model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@Table(name = "UserAccounts")
public class UserAccount {

    @Id
    private UUID id;

    private String name;
    private String nicNumber;
    private String emailAddress;
	
    public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNicNumber() {
		return nicNumber;
	}
	public void setNicNumber(String nicNumber) {
		this.nicNumber = nicNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
