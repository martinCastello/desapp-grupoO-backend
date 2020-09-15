package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class UserBuilder {
	
	public static UserBuilder createUser() {
		return new UserBuilder();
	}
	private String name = "";
	private String mail = "mail@mail.com";
	private String nickName= "secret_donor"; 
	private String password= "genericPassword";
	
	public UserDonator buildDonator() {
		return  new UserDonator(name, mail, nickName, password);
	}
	public AdminUser buildAdmin() {
		return  new AdminUser(name, mail, nickName, password);
	}
	
	public UserBuilder withName(String newName) {
		name= newName;
		return this;
	}
	
	public UserBuilder withMail(String newMail) {
		mail= newMail;
		return this;
	}
	
}