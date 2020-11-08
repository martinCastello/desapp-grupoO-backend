package ar.edu.unq.desapp.grupoo022020.backenddesappapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_USER_AMIN", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_USER_ADMIN")
public class AdminUser extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER_AMIN")
	private Integer id;

	public AdminUser(String name, String mail, String nickName, String password) {
		super(name, mail, nickName, password);
	}

	public void closeProject(Project project) {
		project.close();
	}

	public Integer getId() {
		return this.id;
	}
}