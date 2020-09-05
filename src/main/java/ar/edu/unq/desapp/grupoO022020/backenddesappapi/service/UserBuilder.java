package ar.edu.unq.desapp.grupoO022020.backenddesappapi.service;

public class UserBuilder {
	
	public static UserBuilder createUser() {
		return new UserBuilder();
	}
	private String name = ""; 
	private String nickName= "secret_donor"; 
	private String password= "genericPassword";
	private UserType userType = UserType.Common;
	
	public User build() {
		User newUser=  new User(name, nickName, password, userType);
		return newUser;
	}
	
	public UserBuilder withName(String newName) {
		name= newName;
		return this;
	}
	
	public UserBuilder withType(UserType type) {
		userType= type;
		return this;
	}
}