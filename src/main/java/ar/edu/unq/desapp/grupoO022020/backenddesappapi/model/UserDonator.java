package ar.edu.unq.desapp.grupoO022020.backenddesappapi.model;

public class UserDonator extends User {
	private int points;

	public UserDonator(String name, String mail, String userName, String password) {
		super(name, mail, userName, password);
		this.setPoints(0);
	}

	public void addPoints(int points) {
		this.setPoints(this.getPoints() + points);
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
