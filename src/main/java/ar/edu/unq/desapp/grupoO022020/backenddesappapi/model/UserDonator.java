package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class UserDonator extends User{
	int points;
	
	public UserDonator(String name, String mail, String userName, String password) {
		super(name, mail, userName,password);
		this.points = 0;
	}
}
