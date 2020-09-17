package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.builder;

import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.AdminUser;
import ar.edu.unq.desapp.grupoO022020.backenddesappapi.model.UserDonator;

public class UserBuilder {
	
	private String name = "";
	private String mail = "mail@mail.com";
	private String nickName= "secret_donor"; 
	private String password= "genericPassword";
	
	public static UserBuilder createUser() {
		return new UserBuilder();
	}
	
	public UserBuilder withName(String newName) {
		this.name = newName;
		return this;
	}
	
	public UserBuilder withNickName(String newNickName) {
		this.nickName = newNickName;
		return this;
	}
	
	public UserBuilder withMail(String newMail) {
		this.mail = newMail;
		return this;
	}
	
	public UserDonator buildDonator() {
		return  new UserDonator(name, mail, nickName, password);
	}
	public AdminUser buildAdmin() {
		return  new AdminUser(name, mail, nickName, password);
	}
	
}