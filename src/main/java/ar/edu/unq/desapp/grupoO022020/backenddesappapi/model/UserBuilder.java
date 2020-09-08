package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class UserBuilder {
	
	public static UserBuilder createUser() {
		return new UserBuilder();
	}
	private String name = "";
	private String mail = "mail@mail.com";
	private String nickName= "secret_donor"; 
	private String password= "genericPassword";
	private UserType userType = UserType.Common;
	
	public User build() {
		User newUser=  new User(name, mail, nickName, password, userType);
		return newUser;
	}
	
	public UserBuilder withName(String newName) {
		name= newName;
		return this;
	}
	
	public UserBuilder withMail(String newMail) {
		mail= newMail;
		return this;
	}
	

	
	public UserBuilder adminUser() {
		userType= UserType.Admin;
		return this;
	}
}