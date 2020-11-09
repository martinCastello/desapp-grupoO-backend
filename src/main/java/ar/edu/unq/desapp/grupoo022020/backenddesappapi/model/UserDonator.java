package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_USER_DONATOR", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_USER_DONATOR")
public class UserDonator extends User implements PropertyChangeListener {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_DONATOR")
	private Integer id;
	@Column
	private int points;

	public UserDonator() { }
	
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
		// Se agregaria aca el servicio de mail para poder avisar que se cerro proyecto?
		System.out.println("Variation of " + evt.getPropertyName());
		System.out.println("\t(" + evt.getOldValue() + 
							" -> " + evt.getNewValue() + ")");
		System.out.println("Property in object " + evt.getSource());
		System.out.println("email received successfully");
	}
	
	public Integer getId() {
		return this.id;
	}
	
}
