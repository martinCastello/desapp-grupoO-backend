package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class UserBuilder {
	
	public static UserBuilder createUser() {
		return new UserBuilder();
	}
	private String name = "";
	private String mail = "mail@mail.com";
	private String nickName= "secret_donor"; 
	private String password= "genericPassword";
	
	public User build(UserType type) {
		if(type == UserType.Common) {
			return  new UserDonator(name, mail, nickName, password);
		}
		else {
			return  new AdminUser(name, mail, nickName, password);
		}
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