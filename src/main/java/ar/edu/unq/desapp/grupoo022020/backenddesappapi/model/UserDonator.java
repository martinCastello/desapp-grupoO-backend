package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class UserDonator extends User implements PropertyChangeListener {
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
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Variation of " + evt.getPropertyName());
		System.out.println("\t(" + evt.getOldValue() + 
							" -> " + evt.getNewValue() + ")");
		System.out.println("Property in object " + evt.getSource());
		
		System.out.println("email received successfully");
	}
	
}
